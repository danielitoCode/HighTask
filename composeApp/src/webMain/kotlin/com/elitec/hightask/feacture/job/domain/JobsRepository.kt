package com.elitec.hightask.feacture.job.domain

interface JobsRepository {
    suspend fun getAllJobs(): Result<List<Job>>
    suspend fun getAllJobsByUser(userId: String): Result<List<Job>>
    suspend fun getJobById(jobId: Long): Result<Job>
    suspend fun saveJob(job: Job): Result<Unit>
    suspend fun deleteJob(jobId: Long): Result<Unit>
    suspend fun updateJob(jobId: Long, job: Job): Result<Unit>
}