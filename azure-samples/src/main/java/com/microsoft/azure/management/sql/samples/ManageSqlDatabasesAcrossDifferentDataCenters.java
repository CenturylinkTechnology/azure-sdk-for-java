/**
 *
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for license information.
 *
 */

package com.microsoft.azure.management.sql.samples;

import com.microsoft.azure.management.Azure;
import com.microsoft.azure.management.compute.KnownWindowsVirtualMachineImage;
import com.microsoft.azure.management.compute.VirtualMachine;
import com.microsoft.azure.management.compute.VirtualMachineSizeTypes;
import com.microsoft.azure.management.network.Network;
import com.microsoft.azure.management.network.PublicIpAddress;
import com.microsoft.azure.management.resources.fluentcore.arm.Region;
import com.microsoft.azure.management.resources.fluentcore.model.Creatable;
import com.microsoft.azure.management.resources.fluentcore.model.CreatedResources;
import com.microsoft.azure.management.samples.Utils;
import com.microsoft.azure.management.sql.CreateMode;
import com.microsoft.azure.management.sql.DatabaseEditions;
import com.microsoft.azure.management.sql.SqlDatabase;
import com.microsoft.azure.management.sql.SqlFirewallRule;
import com.microsoft.azure.management.sql.SqlServer;
import okhttp3.logging.HttpLoggingInterceptor;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Azure Storage sample for managing SQL Database -
 *  - Create 3 SQL Servers in different region.
 *  - Create a master database in master SQL Server.
 *  - Create 2 more SQL Servers in different azure regions
 *  - Create secondary read only databases in these server with source as database in server created in step 1.
 *  - Create 5 virtual networks in different regions.
 *  - Create one VM in each of the virtual network.
 *  - Update all three databases to have firewall rules with range of each of the virtual network.
 */

public final class ManageSqlDatabasesAcrossDifferentDataCenters {

    /**
     * Main entry point.
     * @param args the parameters
     */
    public static void main(String[] args) {

        final String sqlServerName = Utils.createRandomName("sqlserver");
        final String rgName = Utils.createRandomName("rgRSSDRE");

        try {

            final File credFile = new File(System.getenv("AZURE_AUTH_LOCATION"));

            Azure azure = Azure
                    .configure()
                    .withLogLevel(HttpLoggingInterceptor.Level.BASIC)
                    .authenticate(credFile)
                    .withDefaultSubscription();

            // Print selected subscription
            System.out.println("Selected subscription: " + azure.subscriptionId());

            try {

                // ============================================================
                // Create a SQL Server, with 2 firewall rules.

                SqlServer masterSqlServer = azure.sqlServers().define(sqlServerName)
                        .withRegion(Region.US_EAST)
                        .withNewResourceGroup(rgName)
                        .withAdministratorLogin("adminlogin123")
                        .withAdministratorPassword("myS3cureP@ssword")
                        .create();

                Utils.print(masterSqlServer);

                // ============================================================
                // Create a Database in master SQL server created above.
                System.out.println("Creating a database");

                SqlDatabase masterDatabase = masterSqlServer.databases().define("mydatabase")
                        .withoutElasticPool()
                        .withoutSourceDatabaseId()
                        .withEdition(DatabaseEditions.BASIC)
                        .create();
                Utils.print(masterDatabase);

                // Create secondary databases for the master database
                SqlServer sqlServerInSecondaryLocation = azure.sqlServers()
                        .define(Utils.createRandomName("slave1sql"))
                        .withRegion(masterDatabase.defaultSecondaryLocation())
                        .withExistingResourceGroup(rgName)
                        .withAdministratorLogin("adminlogin123")
                        .withAdministratorPassword("myS3cureP@ssword")
                        .create();
                Utils.print(sqlServerInSecondaryLocation);

                SqlDatabase secondaryDatabase = sqlServerInSecondaryLocation.databases().define("mydatabase")
                        .withoutElasticPool()
                        .withSourceDatabase(masterDatabase)
                        .withMode(CreateMode.ONLINE_SECONDARY)
                        .create();
                Utils.print(secondaryDatabase);

                SqlServer sqlServerInEurope = azure.sqlServers()
                        .define(Utils.createRandomName("slave2sql"))
                        .withRegion(Region.EUROPE_WEST)
                        .withExistingResourceGroup(rgName)
                        .withAdministratorLogin("adminlogin123")
                        .withAdministratorPassword("myS3cureP@ssword")
                        .create();
                Utils.print(sqlServerInEurope);

                SqlDatabase secondaryDatabaseInEurope = sqlServerInEurope.databases().define("mydatabase")
                        .withoutElasticPool()
                        .withSourceDatabase(masterDatabase)
                        .withMode(CreateMode.ONLINE_SECONDARY)
                        .create();
                Utils.print(secondaryDatabaseInEurope);

                // ============================================================
                // Create Virtual Networks in different regions
                List<Region> regions = new ArrayList<>();
                regions.add(Region.US_EAST);
                regions.add(Region.US_WEST);
                regions.add(Region.EUROPE_NORTH);
                regions.add(Region.ASIA_SOUTHEAST);
                regions.add(Region.JAPAN_EAST);

                List<Creatable<Network>> creatableNetworks = new ArrayList<>();

                for (Region region: regions) {
                    creatableNetworks.add(azure.networks().define(Utils.createRandomName("network"))
                            .withRegion(region)
                            .withExistingResourceGroup(rgName));
                }
                CreatedResources<Network> networks = azure.networks().create(creatableNetworks);

                // ============================================================
                // Create virtual machines attached to different virtual networks created above.
                List<Creatable<VirtualMachine>> creatableVirtualMachines = new ArrayList<>();

                for (Network network: networks) {
                    String vmName = Utils.createRandomName("samplevm");
                    Creatable<PublicIpAddress> publicIpAddressCreatable = azure.publicIpAddresses()
                            .define(vmName)
                            .withRegion(network.region())
                            .withExistingResourceGroup(rgName)
                            .withLeafDomainLabel(vmName);
                    creatableVirtualMachines.add(azure.virtualMachines().define(vmName)
                            .withRegion(network.region())
                            .withExistingResourceGroup(rgName)
                            .withExistingPrimaryNetwork(network)
                            .withSubnet(network.subnets().values().iterator().next().name())
                            .withPrimaryPrivateIpAddressDynamic()
                            .withNewPrimaryPublicIpAddress(publicIpAddressCreatable)
                            .withPopularWindowsImage(KnownWindowsVirtualMachineImage.WINDOWS_SERVER_2012_R2_DATACENTER)
                            .withAdminUsername("admind234")
                            .withAdminPassword("myS3cureP@ssword~2")
                            .withSize(VirtualMachineSizeTypes.STANDARD_D3_V2));
                }

                HashMap<String, String> ipAddresses = new HashMap<>();
                for (VirtualMachine virtualMachine: azure.virtualMachines().create(creatableVirtualMachines)) {
                    ipAddresses.put(virtualMachine.name(), virtualMachine.getPrimaryPublicIpAddress().ipAddress());
                }

                System.out.println("Adding firewall rule for each of virtual network network");

                List<SqlServer> sqlServers = new ArrayList<>();
                sqlServers.add(sqlServerInSecondaryLocation);
                sqlServers.add(sqlServerInEurope);
                sqlServers.add(masterSqlServer);

                for (SqlServer sqlServer: sqlServers) {
                    for (Map.Entry<String, String> ipAddress: ipAddresses.entrySet()) {
                        sqlServer.firewallRules().define(ipAddress.getKey()).withIpAddress(ipAddress.getValue()).create();
                    }
                }

                for (SqlServer sqlServer: sqlServers) {
                    System.out.println("Print firewall rules in Sql Server in " + sqlServer.regionName());

                    List<SqlFirewallRule> firewallRules = sqlServer.firewallRules().list();
                    for (SqlFirewallRule firewallRule: firewallRules) {
                        Utils.print(firewallRule);
                    }
                }

                    // Delete the SQL Server.
                System.out.println("Deleting all Sql Servers");
                for (SqlServer sqlServer: sqlServers) {
                    azure.sqlServers().deleteById(sqlServer.id());
                }

            } catch (Exception f) {
                System.out.println(f.getMessage());
                f.printStackTrace();
            } finally {
                try {
                    System.out.println("Deleting Resource Group: " + rgName);
                    azure.resourceGroups().deleteByName(rgName);
                    System.out.println("Deleted Resource Group: " + rgName);
                }
                catch (Exception e) {
                    System.out.println("Did not create any resources in Azure. No clean up is necessary");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    private ManageSqlDatabasesAcrossDifferentDataCenters() {

    }


}