/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator 0.14.0.0
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package com.microsoft.azure.management.website.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines values for LogLevel.
 */
public enum LogLevel {
    /** Enum value Off. */
    OFF("Off"),

    /** Enum value Verbose. */
    VERBOSE("Verbose"),

    /** Enum value Information. */
    INFORMATION("Information"),

    /** Enum value Warning. */
    WARNING("Warning"),

    /** Enum value Error. */
    ERROR("Error");

    /** The actual serialized value for a LogLevel instance. */
    private String value;

    LogLevel(String value) {
        this.value = value;
    }

    /**
     * Gets the serialized value for a LogLevel instance.
     *
     * @return the serialized value.
     */
    @JsonValue
    public String toValue() {
        return this.value;
    }

    /**
     * Parses a serialized value to a LogLevel instance.
     *
     * @param value the serialized value to parse.
     * @return the parsed LogLevel object, or null if unable to parse.
     */
    @JsonCreator
    public static LogLevel fromValue(String value) {
        LogLevel[] items = LogLevel.values();
        for (LogLevel item : items) {
            if (item.toValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}