package com.elitec.hightask.feacture.job.domain

class GetAllJobsCaseUse(
    private val jobsRepository: JobsRepository
) {
    suspend operator fun invoke(): Result<List<Job>> = runCatching {
        return jobsRepository.getAllJobs()
    }
}