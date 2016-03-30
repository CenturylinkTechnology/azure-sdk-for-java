/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.batch.protocol;

import com.microsoft.azure.batch.protocol.models.BatchErrorException;
import com.microsoft.azure.batch.protocol.models.CloudJob;
import com.microsoft.azure.batch.protocol.models.DisableJobOption;
import com.microsoft.azure.batch.protocol.models.JobAddHeaders;
import com.microsoft.azure.batch.protocol.models.JobAddOptions;
import com.microsoft.azure.batch.protocol.models.JobAddParameter;
import com.microsoft.azure.batch.protocol.models.JobDeleteHeaders;
import com.microsoft.azure.batch.protocol.models.JobDeleteOptions;
import com.microsoft.azure.batch.protocol.models.JobDisableHeaders;
import com.microsoft.azure.batch.protocol.models.JobDisableOptions;
import com.microsoft.azure.batch.protocol.models.JobEnableHeaders;
import com.microsoft.azure.batch.protocol.models.JobEnableOptions;
import com.microsoft.azure.batch.protocol.models.JobGetAllJobsLifetimeStatisticsHeaders;
import com.microsoft.azure.batch.protocol.models.JobGetAllJobsLifetimeStatisticsOptions;
import com.microsoft.azure.batch.protocol.models.JobGetHeaders;
import com.microsoft.azure.batch.protocol.models.JobGetOptions;
import com.microsoft.azure.batch.protocol.models.JobListFromJobScheduleHeaders;
import com.microsoft.azure.batch.protocol.models.JobListFromJobScheduleNextOptions;
import com.microsoft.azure.batch.protocol.models.JobListFromJobScheduleOptions;
import com.microsoft.azure.batch.protocol.models.JobListHeaders;
import com.microsoft.azure.batch.protocol.models.JobListNextOptions;
import com.microsoft.azure.batch.protocol.models.JobListOptions;
import com.microsoft.azure.batch.protocol.models.JobListPreparationAndReleaseTaskStatusHeaders;
import com.microsoft.azure.batch.protocol.models.JobListPreparationAndReleaseTaskStatusNextOptions;
import com.microsoft.azure.batch.protocol.models.JobListPreparationAndReleaseTaskStatusOptions;
import com.microsoft.azure.batch.protocol.models.JobPatchHeaders;
import com.microsoft.azure.batch.protocol.models.JobPatchOptions;
import com.microsoft.azure.batch.protocol.models.JobPatchParameter;
import com.microsoft.azure.batch.protocol.models.JobPreparationAndReleaseTaskExecutionInformation;
import com.microsoft.azure.batch.protocol.models.JobStatistics;
import com.microsoft.azure.batch.protocol.models.JobTerminateHeaders;
import com.microsoft.azure.batch.protocol.models.JobTerminateOptions;
import com.microsoft.azure.batch.protocol.models.JobUpdateHeaders;
import com.microsoft.azure.batch.protocol.models.JobUpdateOptions;
import com.microsoft.azure.batch.protocol.models.JobUpdateParameter;
import com.microsoft.azure.batch.protocol.models.PageImpl;
import com.microsoft.azure.ListOperationCallback;
import com.microsoft.azure.PagedList;
import com.microsoft.rest.ServiceCall;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceResponseWithHeaders;
import java.io.IOException;

/**
 * An instance of this class provides access to all the operations defined
 * in JobOperations.
 */
public interface JobOperations {
    /**
     * Gets lifetime summary statistics for all of the jobs in the specified account. Statistics are aggregated across all jobs that have ever existed in the account, from account creation to the last update time of the statistics.
     *
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the JobStatistics object wrapped in {@link ServiceResponseWithHeaders} if successful.
     */
    ServiceResponseWithHeaders<JobStatistics, JobGetAllJobsLifetimeStatisticsHeaders> getAllJobsLifetimeStatistics() throws BatchErrorException, IOException, IllegalArgumentException;

    /**
     * Gets lifetime summary statistics for all of the jobs in the specified account. Statistics are aggregated across all jobs that have ever existed in the account, from account creation to the last update time of the statistics.
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall getAllJobsLifetimeStatisticsAsync(final ServiceCallback<JobStatistics> serviceCallback) throws IllegalArgumentException;
    /**
     * Gets lifetime summary statistics for all of the jobs in the specified account. Statistics are aggregated across all jobs that have ever existed in the account, from account creation to the last update time of the statistics.
     *
     * @param jobGetAllJobsLifetimeStatisticsOptions Additional parameters for the operation
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the JobStatistics object wrapped in {@link ServiceResponseWithHeaders} if successful.
     */
    ServiceResponseWithHeaders<JobStatistics, JobGetAllJobsLifetimeStatisticsHeaders> getAllJobsLifetimeStatistics(JobGetAllJobsLifetimeStatisticsOptions jobGetAllJobsLifetimeStatisticsOptions) throws BatchErrorException, IOException, IllegalArgumentException;

    /**
     * Gets lifetime summary statistics for all of the jobs in the specified account. Statistics are aggregated across all jobs that have ever existed in the account, from account creation to the last update time of the statistics.
     *
     * @param jobGetAllJobsLifetimeStatisticsOptions Additional parameters for the operation
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall getAllJobsLifetimeStatisticsAsync(JobGetAllJobsLifetimeStatisticsOptions jobGetAllJobsLifetimeStatisticsOptions, final ServiceCallback<JobStatistics> serviceCallback) throws IllegalArgumentException;

    /**
     * Deletes a job.
     *
     * @param jobId The id of the job to delete.
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponseWithHeaders} object if successful.
     */
    ServiceResponseWithHeaders<Void, JobDeleteHeaders> delete(String jobId) throws BatchErrorException, IOException, IllegalArgumentException;

    /**
     * Deletes a job.
     *
     * @param jobId The id of the job to delete.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall deleteAsync(String jobId, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException;
    /**
     * Deletes a job.
     *
     * @param jobId The id of the job to delete.
     * @param jobDeleteOptions Additional parameters for the operation
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponseWithHeaders} object if successful.
     */
    ServiceResponseWithHeaders<Void, JobDeleteHeaders> delete(String jobId, JobDeleteOptions jobDeleteOptions) throws BatchErrorException, IOException, IllegalArgumentException;

    /**
     * Deletes a job.
     *
     * @param jobId The id of the job to delete.
     * @param jobDeleteOptions Additional parameters for the operation
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall deleteAsync(String jobId, JobDeleteOptions jobDeleteOptions, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException;

    /**
     * Gets information about the specified job.
     *
     * @param jobId The id of the job.
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the CloudJob object wrapped in {@link ServiceResponseWithHeaders} if successful.
     */
    ServiceResponseWithHeaders<CloudJob, JobGetHeaders> get(String jobId) throws BatchErrorException, IOException, IllegalArgumentException;

    /**
     * Gets information about the specified job.
     *
     * @param jobId The id of the job.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall getAsync(String jobId, final ServiceCallback<CloudJob> serviceCallback) throws IllegalArgumentException;
    /**
     * Gets information about the specified job.
     *
     * @param jobId The id of the job.
     * @param jobGetOptions Additional parameters for the operation
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the CloudJob object wrapped in {@link ServiceResponseWithHeaders} if successful.
     */
    ServiceResponseWithHeaders<CloudJob, JobGetHeaders> get(String jobId, JobGetOptions jobGetOptions) throws BatchErrorException, IOException, IllegalArgumentException;

    /**
     * Gets information about the specified job.
     *
     * @param jobId The id of the job.
     * @param jobGetOptions Additional parameters for the operation
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall getAsync(String jobId, JobGetOptions jobGetOptions, final ServiceCallback<CloudJob> serviceCallback) throws IllegalArgumentException;

    /**
     * Updates the properties of a job.
     *
     * @param jobId The id of the job whose properties you want to update.
     * @param jobPatchParameter The parameters for the request.
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponseWithHeaders} object if successful.
     */
    ServiceResponseWithHeaders<Void, JobPatchHeaders> patch(String jobId, JobPatchParameter jobPatchParameter) throws BatchErrorException, IOException, IllegalArgumentException;

    /**
     * Updates the properties of a job.
     *
     * @param jobId The id of the job whose properties you want to update.
     * @param jobPatchParameter The parameters for the request.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall patchAsync(String jobId, JobPatchParameter jobPatchParameter, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException;
    /**
     * Updates the properties of a job.
     *
     * @param jobId The id of the job whose properties you want to update.
     * @param jobPatchParameter The parameters for the request.
     * @param jobPatchOptions Additional parameters for the operation
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponseWithHeaders} object if successful.
     */
    ServiceResponseWithHeaders<Void, JobPatchHeaders> patch(String jobId, JobPatchParameter jobPatchParameter, JobPatchOptions jobPatchOptions) throws BatchErrorException, IOException, IllegalArgumentException;

    /**
     * Updates the properties of a job.
     *
     * @param jobId The id of the job whose properties you want to update.
     * @param jobPatchParameter The parameters for the request.
     * @param jobPatchOptions Additional parameters for the operation
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall patchAsync(String jobId, JobPatchParameter jobPatchParameter, JobPatchOptions jobPatchOptions, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException;

    /**
     * Updates the properties of a job.
     *
     * @param jobId The id of the job whose properties you want to update.
     * @param jobUpdateParameter The parameters for the request.
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponseWithHeaders} object if successful.
     */
    ServiceResponseWithHeaders<Void, JobUpdateHeaders> update(String jobId, JobUpdateParameter jobUpdateParameter) throws BatchErrorException, IOException, IllegalArgumentException;

    /**
     * Updates the properties of a job.
     *
     * @param jobId The id of the job whose properties you want to update.
     * @param jobUpdateParameter The parameters for the request.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall updateAsync(String jobId, JobUpdateParameter jobUpdateParameter, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException;
    /**
     * Updates the properties of a job.
     *
     * @param jobId The id of the job whose properties you want to update.
     * @param jobUpdateParameter The parameters for the request.
     * @param jobUpdateOptions Additional parameters for the operation
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponseWithHeaders} object if successful.
     */
    ServiceResponseWithHeaders<Void, JobUpdateHeaders> update(String jobId, JobUpdateParameter jobUpdateParameter, JobUpdateOptions jobUpdateOptions) throws BatchErrorException, IOException, IllegalArgumentException;

    /**
     * Updates the properties of a job.
     *
     * @param jobId The id of the job whose properties you want to update.
     * @param jobUpdateParameter The parameters for the request.
     * @param jobUpdateOptions Additional parameters for the operation
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall updateAsync(String jobId, JobUpdateParameter jobUpdateParameter, JobUpdateOptions jobUpdateOptions, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException;

    /**
     * Disables the specified job, preventing new tasks from running.
     *
     * @param jobId The id of the job to disable.
     * @param disableTasks Sets what to do with active tasks associated with the job. Possible values include: 'requeue', 'terminate', 'wait'
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponseWithHeaders} object if successful.
     */
    ServiceResponseWithHeaders<Void, JobDisableHeaders> disable(String jobId, DisableJobOption disableTasks) throws BatchErrorException, IOException, IllegalArgumentException;

    /**
     * Disables the specified job, preventing new tasks from running.
     *
     * @param jobId The id of the job to disable.
     * @param disableTasks Sets what to do with active tasks associated with the job. Possible values include: 'requeue', 'terminate', 'wait'
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall disableAsync(String jobId, DisableJobOption disableTasks, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException;
    /**
     * Disables the specified job, preventing new tasks from running.
     *
     * @param jobId The id of the job to disable.
     * @param disableTasks Sets what to do with active tasks associated with the job. Possible values include: 'requeue', 'terminate', 'wait'
     * @param jobDisableOptions Additional parameters for the operation
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponseWithHeaders} object if successful.
     */
    ServiceResponseWithHeaders<Void, JobDisableHeaders> disable(String jobId, DisableJobOption disableTasks, JobDisableOptions jobDisableOptions) throws BatchErrorException, IOException, IllegalArgumentException;

    /**
     * Disables the specified job, preventing new tasks from running.
     *
     * @param jobId The id of the job to disable.
     * @param disableTasks Sets what to do with active tasks associated with the job. Possible values include: 'requeue', 'terminate', 'wait'
     * @param jobDisableOptions Additional parameters for the operation
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall disableAsync(String jobId, DisableJobOption disableTasks, JobDisableOptions jobDisableOptions, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException;

    /**
     * Enables the specified job, allowing new tasks to run.
     *
     * @param jobId The id of the job to enable.
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponseWithHeaders} object if successful.
     */
    ServiceResponseWithHeaders<Void, JobEnableHeaders> enable(String jobId) throws BatchErrorException, IOException, IllegalArgumentException;

    /**
     * Enables the specified job, allowing new tasks to run.
     *
     * @param jobId The id of the job to enable.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall enableAsync(String jobId, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException;
    /**
     * Enables the specified job, allowing new tasks to run.
     *
     * @param jobId The id of the job to enable.
     * @param jobEnableOptions Additional parameters for the operation
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponseWithHeaders} object if successful.
     */
    ServiceResponseWithHeaders<Void, JobEnableHeaders> enable(String jobId, JobEnableOptions jobEnableOptions) throws BatchErrorException, IOException, IllegalArgumentException;

    /**
     * Enables the specified job, allowing new tasks to run.
     *
     * @param jobId The id of the job to enable.
     * @param jobEnableOptions Additional parameters for the operation
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall enableAsync(String jobId, JobEnableOptions jobEnableOptions, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException;

    /**
     * Terminates the specified job, marking it as completed.
     *
     * @param jobId The id of the job to terminate.
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponseWithHeaders} object if successful.
     */
    ServiceResponseWithHeaders<Void, JobTerminateHeaders> terminate(String jobId) throws BatchErrorException, IOException, IllegalArgumentException;

    /**
     * Terminates the specified job, marking it as completed.
     *
     * @param jobId The id of the job to terminate.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall terminateAsync(String jobId, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException;
    /**
     * Terminates the specified job, marking it as completed.
     *
     * @param jobId The id of the job to terminate.
     * @param terminateReason Sets the text you want to appear as the job's TerminateReason. The default is 'UserTerminate'.
     * @param jobTerminateOptions Additional parameters for the operation
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponseWithHeaders} object if successful.
     */
    ServiceResponseWithHeaders<Void, JobTerminateHeaders> terminate(String jobId, String terminateReason, JobTerminateOptions jobTerminateOptions) throws BatchErrorException, IOException, IllegalArgumentException;

    /**
     * Terminates the specified job, marking it as completed.
     *
     * @param jobId The id of the job to terminate.
     * @param terminateReason Sets the text you want to appear as the job's TerminateReason. The default is 'UserTerminate'.
     * @param jobTerminateOptions Additional parameters for the operation
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall terminateAsync(String jobId, String terminateReason, JobTerminateOptions jobTerminateOptions, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException;

    /**
     * Adds a job to the specified account.
     *
     * @param job Specifies the job to be added.
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponseWithHeaders} object if successful.
     */
    ServiceResponseWithHeaders<Void, JobAddHeaders> add(JobAddParameter job) throws BatchErrorException, IOException, IllegalArgumentException;

    /**
     * Adds a job to the specified account.
     *
     * @param job Specifies the job to be added.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall addAsync(JobAddParameter job, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException;
    /**
     * Adds a job to the specified account.
     *
     * @param job Specifies the job to be added.
     * @param jobAddOptions Additional parameters for the operation
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponseWithHeaders} object if successful.
     */
    ServiceResponseWithHeaders<Void, JobAddHeaders> add(JobAddParameter job, JobAddOptions jobAddOptions) throws BatchErrorException, IOException, IllegalArgumentException;

    /**
     * Adds a job to the specified account.
     *
     * @param job Specifies the job to be added.
     * @param jobAddOptions Additional parameters for the operation
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall addAsync(JobAddParameter job, JobAddOptions jobAddOptions, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException;

    /**
     * Lists all of the jobs in the specified account.
     *
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the List&lt;CloudJob&gt; object wrapped in {@link ServiceResponseWithHeaders} if successful.
     */
    ServiceResponseWithHeaders<PagedList<CloudJob>, JobListHeaders> list() throws BatchErrorException, IOException, IllegalArgumentException;

    /**
     * Lists all of the jobs in the specified account.
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall listAsync(final ListOperationCallback<CloudJob> serviceCallback) throws IllegalArgumentException;
    /**
     * Lists all of the jobs in the specified account.
     *
     * @param jobListOptions Additional parameters for the operation
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the List&lt;CloudJob&gt; object wrapped in {@link ServiceResponseWithHeaders} if successful.
     */
    ServiceResponseWithHeaders<PagedList<CloudJob>, JobListHeaders> list(final JobListOptions jobListOptions) throws BatchErrorException, IOException, IllegalArgumentException;

    /**
     * Lists all of the jobs in the specified account.
     *
     * @param jobListOptions Additional parameters for the operation
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall listAsync(final JobListOptions jobListOptions, final ListOperationCallback<CloudJob> serviceCallback) throws IllegalArgumentException;

    /**
     * Lists the jobs that have been created under the specified job schedule.
     *
     * @param jobScheduleId The id of the job schedule from which you want to get a list of jobs.
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the List&lt;CloudJob&gt; object wrapped in {@link ServiceResponseWithHeaders} if successful.
     */
    ServiceResponseWithHeaders<PagedList<CloudJob>, JobListFromJobScheduleHeaders> listFromJobSchedule(final String jobScheduleId) throws BatchErrorException, IOException, IllegalArgumentException;

    /**
     * Lists the jobs that have been created under the specified job schedule.
     *
     * @param jobScheduleId The id of the job schedule from which you want to get a list of jobs.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall listFromJobScheduleAsync(final String jobScheduleId, final ListOperationCallback<CloudJob> serviceCallback) throws IllegalArgumentException;
    /**
     * Lists the jobs that have been created under the specified job schedule.
     *
     * @param jobScheduleId The id of the job schedule from which you want to get a list of jobs.
     * @param jobListFromJobScheduleOptions Additional parameters for the operation
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the List&lt;CloudJob&gt; object wrapped in {@link ServiceResponseWithHeaders} if successful.
     */
    ServiceResponseWithHeaders<PagedList<CloudJob>, JobListFromJobScheduleHeaders> listFromJobSchedule(final String jobScheduleId, final JobListFromJobScheduleOptions jobListFromJobScheduleOptions) throws BatchErrorException, IOException, IllegalArgumentException;

    /**
     * Lists the jobs that have been created under the specified job schedule.
     *
     * @param jobScheduleId The id of the job schedule from which you want to get a list of jobs.
     * @param jobListFromJobScheduleOptions Additional parameters for the operation
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall listFromJobScheduleAsync(final String jobScheduleId, final JobListFromJobScheduleOptions jobListFromJobScheduleOptions, final ListOperationCallback<CloudJob> serviceCallback) throws IllegalArgumentException;

    /**
     * Lists the execution status of the Job Preparation and Job Release task for the specified job across the compute nodes where the job has run.
     *
     * @param jobId The id of the job.
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the List&lt;JobPreparationAndReleaseTaskExecutionInformation&gt; object wrapped in {@link ServiceResponseWithHeaders} if successful.
     */
    ServiceResponseWithHeaders<PagedList<JobPreparationAndReleaseTaskExecutionInformation>, JobListPreparationAndReleaseTaskStatusHeaders> listPreparationAndReleaseTaskStatus(final String jobId) throws BatchErrorException, IOException, IllegalArgumentException;

    /**
     * Lists the execution status of the Job Preparation and Job Release task for the specified job across the compute nodes where the job has run.
     *
     * @param jobId The id of the job.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall listPreparationAndReleaseTaskStatusAsync(final String jobId, final ListOperationCallback<JobPreparationAndReleaseTaskExecutionInformation> serviceCallback) throws IllegalArgumentException;
    /**
     * Lists the execution status of the Job Preparation and Job Release task for the specified job across the compute nodes where the job has run.
     *
     * @param jobId The id of the job.
     * @param jobListPreparationAndReleaseTaskStatusOptions Additional parameters for the operation
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the List&lt;JobPreparationAndReleaseTaskExecutionInformation&gt; object wrapped in {@link ServiceResponseWithHeaders} if successful.
     */
    ServiceResponseWithHeaders<PagedList<JobPreparationAndReleaseTaskExecutionInformation>, JobListPreparationAndReleaseTaskStatusHeaders> listPreparationAndReleaseTaskStatus(final String jobId, final JobListPreparationAndReleaseTaskStatusOptions jobListPreparationAndReleaseTaskStatusOptions) throws BatchErrorException, IOException, IllegalArgumentException;

    /**
     * Lists the execution status of the Job Preparation and Job Release task for the specified job across the compute nodes where the job has run.
     *
     * @param jobId The id of the job.
     * @param jobListPreparationAndReleaseTaskStatusOptions Additional parameters for the operation
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall listPreparationAndReleaseTaskStatusAsync(final String jobId, final JobListPreparationAndReleaseTaskStatusOptions jobListPreparationAndReleaseTaskStatusOptions, final ListOperationCallback<JobPreparationAndReleaseTaskExecutionInformation> serviceCallback) throws IllegalArgumentException;

    /**
     * Lists all of the jobs in the specified account.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the List&lt;CloudJob&gt; object wrapped in {@link ServiceResponseWithHeaders} if successful.
     */
    ServiceResponseWithHeaders<PageImpl<CloudJob>, JobListHeaders> listNext(final String nextPageLink) throws BatchErrorException, IOException, IllegalArgumentException;

    /**
     * Lists all of the jobs in the specified account.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @param serviceCall the ServiceCall object tracking the Retrofit calls
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall listNextAsync(final String nextPageLink, final ServiceCall serviceCall, final ListOperationCallback<CloudJob> serviceCallback) throws IllegalArgumentException;
    /**
     * Lists all of the jobs in the specified account.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @param jobListNextOptions Additional parameters for the operation
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the List&lt;CloudJob&gt; object wrapped in {@link ServiceResponseWithHeaders} if successful.
     */
    ServiceResponseWithHeaders<PageImpl<CloudJob>, JobListHeaders> listNext(final String nextPageLink, final JobListNextOptions jobListNextOptions) throws BatchErrorException, IOException, IllegalArgumentException;

    /**
     * Lists all of the jobs in the specified account.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @param jobListNextOptions Additional parameters for the operation
     * @param serviceCall the ServiceCall object tracking the Retrofit calls
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall listNextAsync(final String nextPageLink, final JobListNextOptions jobListNextOptions, final ServiceCall serviceCall, final ListOperationCallback<CloudJob> serviceCallback) throws IllegalArgumentException;

    /**
     * Lists the jobs that have been created under the specified job schedule.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the List&lt;CloudJob&gt; object wrapped in {@link ServiceResponseWithHeaders} if successful.
     */
    ServiceResponseWithHeaders<PageImpl<CloudJob>, JobListFromJobScheduleHeaders> listFromJobScheduleNext(final String nextPageLink) throws BatchErrorException, IOException, IllegalArgumentException;

    /**
     * Lists the jobs that have been created under the specified job schedule.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @param serviceCall the ServiceCall object tracking the Retrofit calls
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall listFromJobScheduleNextAsync(final String nextPageLink, final ServiceCall serviceCall, final ListOperationCallback<CloudJob> serviceCallback) throws IllegalArgumentException;
    /**
     * Lists the jobs that have been created under the specified job schedule.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @param jobListFromJobScheduleNextOptions Additional parameters for the operation
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the List&lt;CloudJob&gt; object wrapped in {@link ServiceResponseWithHeaders} if successful.
     */
    ServiceResponseWithHeaders<PageImpl<CloudJob>, JobListFromJobScheduleHeaders> listFromJobScheduleNext(final String nextPageLink, final JobListFromJobScheduleNextOptions jobListFromJobScheduleNextOptions) throws BatchErrorException, IOException, IllegalArgumentException;

    /**
     * Lists the jobs that have been created under the specified job schedule.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @param jobListFromJobScheduleNextOptions Additional parameters for the operation
     * @param serviceCall the ServiceCall object tracking the Retrofit calls
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall listFromJobScheduleNextAsync(final String nextPageLink, final JobListFromJobScheduleNextOptions jobListFromJobScheduleNextOptions, final ServiceCall serviceCall, final ListOperationCallback<CloudJob> serviceCallback) throws IllegalArgumentException;

    /**
     * Lists the execution status of the Job Preparation and Job Release task for the specified job across the compute nodes where the job has run.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the List&lt;JobPreparationAndReleaseTaskExecutionInformation&gt; object wrapped in {@link ServiceResponseWithHeaders} if successful.
     */
    ServiceResponseWithHeaders<PageImpl<JobPreparationAndReleaseTaskExecutionInformation>, JobListPreparationAndReleaseTaskStatusHeaders> listPreparationAndReleaseTaskStatusNext(final String nextPageLink) throws BatchErrorException, IOException, IllegalArgumentException;

    /**
     * Lists the execution status of the Job Preparation and Job Release task for the specified job across the compute nodes where the job has run.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @param serviceCall the ServiceCall object tracking the Retrofit calls
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall listPreparationAndReleaseTaskStatusNextAsync(final String nextPageLink, final ServiceCall serviceCall, final ListOperationCallback<JobPreparationAndReleaseTaskExecutionInformation> serviceCallback) throws IllegalArgumentException;
    /**
     * Lists the execution status of the Job Preparation and Job Release task for the specified job across the compute nodes where the job has run.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @param jobListPreparationAndReleaseTaskStatusNextOptions Additional parameters for the operation
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the List&lt;JobPreparationAndReleaseTaskExecutionInformation&gt; object wrapped in {@link ServiceResponseWithHeaders} if successful.
     */
    ServiceResponseWithHeaders<PageImpl<JobPreparationAndReleaseTaskExecutionInformation>, JobListPreparationAndReleaseTaskStatusHeaders> listPreparationAndReleaseTaskStatusNext(final String nextPageLink, final JobListPreparationAndReleaseTaskStatusNextOptions jobListPreparationAndReleaseTaskStatusNextOptions) throws BatchErrorException, IOException, IllegalArgumentException;

    /**
     * Lists the execution status of the Job Preparation and Job Release task for the specified job across the compute nodes where the job has run.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @param jobListPreparationAndReleaseTaskStatusNextOptions Additional parameters for the operation
     * @param serviceCall the ServiceCall object tracking the Retrofit calls
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall listPreparationAndReleaseTaskStatusNextAsync(final String nextPageLink, final JobListPreparationAndReleaseTaskStatusNextOptions jobListPreparationAndReleaseTaskStatusNextOptions, final ServiceCall serviceCall, final ListOperationCallback<JobPreparationAndReleaseTaskExecutionInformation> serviceCallback) throws IllegalArgumentException;

}
