/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.batch.protocol.models;


/**
 * Parameters for a ComputeNodeOperations.Reimage request.
 */
public class NodeReimageParameter {
    /**
     * Sets when to reimage the compute node and what to do with currently
     * running tasks. The default value is requeue. Possible values include:
     * 'requeue', 'terminate', 'taskcompletion', 'retaineddata'.
     */
    private ComputeNodeReimageOption nodeReimageOption;

    /**
     * Get the nodeReimageOption value.
     *
     * @return the nodeReimageOption value
     */
    public ComputeNodeReimageOption getNodeReimageOption() {
        return this.nodeReimageOption;
    }

    /**
     * Set the nodeReimageOption value.
     *
     * @param nodeReimageOption the nodeReimageOption value to set
     */
    public void setNodeReimageOption(ComputeNodeReimageOption nodeReimageOption) {
        this.nodeReimageOption = nodeReimageOption;
    }

}
