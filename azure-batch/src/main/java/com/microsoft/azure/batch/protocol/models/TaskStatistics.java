/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.batch.protocol.models;

import org.joda.time.DateTime;
import org.joda.time.Period;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Resource usage statistics for a task.
 */
public class TaskStatistics {
    /**
     * Gets or sets the URL for the statistics.
     */
    @JsonProperty(required = true)
    private String url;

    /**
     * Gets or sets the start time of the time range covered by the statistics.
     */
    @JsonProperty(required = true)
    private DateTime startTime;

    /**
     * Gets or sets the time at which the statistics were last updated. All
     * statistics are limited to the range between startTime and
     * lastUpdateTime.
     */
    @JsonProperty(required = true)
    private DateTime lastUpdateTime;

    /**
     * Gets or sets the total user mode CPU time (summed across all cores and
     * all compute nodes) consumed by the task.
     */
    @JsonProperty(required = true)
    private Period userCPUTime;

    /**
     * Gets or sets the total kernel mode CPU time (summed across all cores
     * and all compute nodes) consumed by the task.
     */
    @JsonProperty(required = true)
    private Period kernelCPUTime;

    /**
     * Gets or sets the total wall clock time of the task.
     */
    @JsonProperty(required = true)
    private Period wallClockTime;

    /**
     * Gets or sets the total number of I/O read operations performed by the
     * task.
     */
    @JsonProperty(required = true)
    private long readIOps;

    /**
     * Gets or sets the total number of I/O write operations performed by the
     * task.
     */
    @JsonProperty(required = true)
    private long writeIOps;

    /**
     * Gets or sets the total amount of data in GiB of I/O read by the task.
     */
    @JsonProperty(required = true)
    private double readIOGiB;

    /**
     * Gets or sets the total amount of data in GiB of I/O written by the task.
     */
    @JsonProperty(required = true)
    private double writeIOGiB;

    /**
     * Gets or sets the elapsed time between the creation of the task and the
     * start of task execution.
     */
    @JsonProperty(required = true)
    private Period waitTime;

    /**
     * Get the url value.
     *
     * @return the url value
     */
    public String getUrl() {
        return this.url;
    }

    /**
     * Set the url value.
     *
     * @param url the url value to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Get the startTime value.
     *
     * @return the startTime value
     */
    public DateTime getStartTime() {
        return this.startTime;
    }

    /**
     * Set the startTime value.
     *
     * @param startTime the startTime value to set
     */
    public void setStartTime(DateTime startTime) {
        this.startTime = startTime;
    }

    /**
     * Get the lastUpdateTime value.
     *
     * @return the lastUpdateTime value
     */
    public DateTime getLastUpdateTime() {
        return this.lastUpdateTime;
    }

    /**
     * Set the lastUpdateTime value.
     *
     * @param lastUpdateTime the lastUpdateTime value to set
     */
    public void setLastUpdateTime(DateTime lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    /**
     * Get the userCPUTime value.
     *
     * @return the userCPUTime value
     */
    public Period getUserCPUTime() {
        return this.userCPUTime;
    }

    /**
     * Set the userCPUTime value.
     *
     * @param userCPUTime the userCPUTime value to set
     */
    public void setUserCPUTime(Period userCPUTime) {
        this.userCPUTime = userCPUTime;
    }

    /**
     * Get the kernelCPUTime value.
     *
     * @return the kernelCPUTime value
     */
    public Period getKernelCPUTime() {
        return this.kernelCPUTime;
    }

    /**
     * Set the kernelCPUTime value.
     *
     * @param kernelCPUTime the kernelCPUTime value to set
     */
    public void setKernelCPUTime(Period kernelCPUTime) {
        this.kernelCPUTime = kernelCPUTime;
    }

    /**
     * Get the wallClockTime value.
     *
     * @return the wallClockTime value
     */
    public Period getWallClockTime() {
        return this.wallClockTime;
    }

    /**
     * Set the wallClockTime value.
     *
     * @param wallClockTime the wallClockTime value to set
     */
    public void setWallClockTime(Period wallClockTime) {
        this.wallClockTime = wallClockTime;
    }

    /**
     * Get the readIOps value.
     *
     * @return the readIOps value
     */
    public long getReadIOps() {
        return this.readIOps;
    }

    /**
     * Set the readIOps value.
     *
     * @param readIOps the readIOps value to set
     */
    public void setReadIOps(long readIOps) {
        this.readIOps = readIOps;
    }

    /**
     * Get the writeIOps value.
     *
     * @return the writeIOps value
     */
    public long getWriteIOps() {
        return this.writeIOps;
    }

    /**
     * Set the writeIOps value.
     *
     * @param writeIOps the writeIOps value to set
     */
    public void setWriteIOps(long writeIOps) {
        this.writeIOps = writeIOps;
    }

    /**
     * Get the readIOGiB value.
     *
     * @return the readIOGiB value
     */
    public double getReadIOGiB() {
        return this.readIOGiB;
    }

    /**
     * Set the readIOGiB value.
     *
     * @param readIOGiB the readIOGiB value to set
     */
    public void setReadIOGiB(double readIOGiB) {
        this.readIOGiB = readIOGiB;
    }

    /**
     * Get the writeIOGiB value.
     *
     * @return the writeIOGiB value
     */
    public double getWriteIOGiB() {
        return this.writeIOGiB;
    }

    /**
     * Set the writeIOGiB value.
     *
     * @param writeIOGiB the writeIOGiB value to set
     */
    public void setWriteIOGiB(double writeIOGiB) {
        this.writeIOGiB = writeIOGiB;
    }

    /**
     * Get the waitTime value.
     *
     * @return the waitTime value
     */
    public Period getWaitTime() {
        return this.waitTime;
    }

    /**
     * Set the waitTime value.
     *
     * @param waitTime the waitTime value to set
     */
    public void setWaitTime(Period waitTime) {
        this.waitTime = waitTime;
    }

}
