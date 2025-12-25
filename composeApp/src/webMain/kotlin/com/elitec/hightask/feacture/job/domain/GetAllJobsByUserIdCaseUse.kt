package com.elitec.hightask.feacture.job.domain

class GetAllJobsByUserIdCaseUse(
    private val jobsRepository: JobsRepository
) {
    suspend operator fun invoke(userId: String): Result<List<Job>> = runCatching {
        return jobsRepository.getAllJobs()
    }
}