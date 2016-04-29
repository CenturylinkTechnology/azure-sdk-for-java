package com.microsoft.azure.implementation;

import com.microsoft.azure.management.resources.fluentcore.arm.implementation.AzureConfigureBaseImpl;
import com.microsoft.rest.credentials.ServiceClientCredentials;

final class AzureConfigureImpl extends AzureConfigureBaseImpl<Azure.Configure>
    implements Azure.Configure {
    AzureConfigureImpl() {}

    @Override
    public Azure.Authenticated authenticate(ServiceClientCredentials credentials) {
        this.restClient = this.restClientBuilder.withCredentials(credentials).build();
        return new AzureAuthenticatedImpl(this.restClient);
    }
}
