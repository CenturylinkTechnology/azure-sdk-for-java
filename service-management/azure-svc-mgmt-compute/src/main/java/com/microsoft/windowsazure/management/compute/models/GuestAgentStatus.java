/**
 * 
 * Copyright (c) Microsoft and contributors.  All rights reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * 
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

// Warning: This code was generated by a tool.
// 
// Changes to this file may cause incorrect behavior and will be lost if the
// code is regenerated.

package com.microsoft.windowsazure.management.compute.models;

import java.util.Calendar;

/**
* Optional. This object contains status information of the Guest Agent
* installed on a RoleInstance. Guest Agent can be installed on a role instance
* by setting "ProvisionGuestAgent" to true in Create Deployment or Add Role
* API calls. Version header: Required to be "2014-04-01" or later.
*/
public class GuestAgentStatus {
    private Integer code;
    
    /**
    * Optional. Integer. Status code from the result of applying the GA
    * settings.
    * @return The Code value.
    */
    public Integer getCode() {
        return this.code;
    }
    
    /**
    * Optional. Integer. Status code from the result of applying the GA
    * settings.
    * @param codeValue The Code value.
    */
    public void setCode(final Integer codeValue) {
        this.code = codeValue;
    }
    
    private GuestAgentFormattedMessage formattedMessage;
    
    /**
    * Optional. This object encapsulates a formatted localized status message
    * from the Guest Agent.
    * @return The FormattedMessage value.
    */
    public GuestAgentFormattedMessage getFormattedMessage() {
        return this.formattedMessage;
    }
    
    /**
    * Optional. This object encapsulates a formatted localized status message
    * from the Guest Agent.
    * @param formattedMessageValue The FormattedMessage value.
    */
    public void setFormattedMessage(final GuestAgentFormattedMessage formattedMessageValue) {
        this.formattedMessage = formattedMessageValue;
    }
    
    private String guestAgentVersion;
    
    /**
    * Optional. Version of the Guest Agent installed on the role instance.
    * @return The GuestAgentVersion value.
    */
    public String getGuestAgentVersion() {
        return this.guestAgentVersion;
    }
    
    /**
    * Optional. Version of the Guest Agent installed on the role instance.
    * @param guestAgentVersionValue The GuestAgentVersion value.
    */
    public void setGuestAgentVersion(final String guestAgentVersionValue) {
        this.guestAgentVersion = guestAgentVersionValue;
    }
    
    private GuestAgentMessage message;
    
    /**
    * Optional. This object encapsulates a localized status message from the
    * Guest Agent.
    * @return The Message value.
    */
    public GuestAgentMessage getMessage() {
        return this.message;
    }
    
    /**
    * Optional. This object encapsulates a localized status message from the
    * Guest Agent.
    * @param messageValue The Message value.
    */
    public void setMessage(final GuestAgentMessage messageValue) {
        this.message = messageValue;
    }
    
    private String protocolVersion;
    
    /**
    * Optional. Protocol version used by the Guest Agent for status reporting.
    * @return The ProtocolVersion value.
    */
    public String getProtocolVersion() {
        return this.protocolVersion;
    }
    
    /**
    * Optional. Protocol version used by the Guest Agent for status reporting.
    * @param protocolVersionValue The ProtocolVersion value.
    */
    public void setProtocolVersion(final String protocolVersionValue) {
        this.protocolVersion = protocolVersionValue;
    }
    
    private String status;
    
    /**
    * Optional. The guest agent status, which can be: "Ready" or "NotReady".
    * @return The Status value.
    */
    public String getStatus() {
        return this.status;
    }
    
    /**
    * Optional. The guest agent status, which can be: "Ready" or "NotReady".
    * @param statusValue The Status value.
    */
    public void setStatus(final String statusValue) {
        this.status = statusValue;
    }
    
    private Calendar timestamp;
    
    /**
    * Optional. UTC time at which the status was reported.
    * @return The Timestamp value.
    */
    public Calendar getTimestamp() {
        return this.timestamp;
    }
    
    /**
    * Optional. UTC time at which the status was reported.
    * @param timestampValue The Timestamp value.
    */
    public void setTimestamp(final Calendar timestampValue) {
        this.timestamp = timestampValue;
    }
}