package com.elitec.hightask.feacture.job.data.net

import com.elitec.hightask.feacture.job.data.dto.JobDto
import com.elitec.hightask.feacture.job.data.mappers.toDomain
import com.elitec.hightask.feacture.job.data.mappers.toDto
import com.elitec.hightask.feacture.job.domain.Job
import com.elitec.hightask.feacture.job.domain.JobsRepository
import com.elitec.hightask.infraestructure.data.InfrastructureInfo
import com.elitec.hightask.infraestructure.data.dto.AppwriteCreateDocumentDto
import com.elitec.hightask.infraestructure.data.dto.AppwriteDocumentDto
import com.elitec.hightask.infraestructure.data.dto.AppwriteListDto
import com.elitec.hightask.infraestructure.data.dto.AppwriteUpdateDocumentDto
import com.elitec.hightask.infraestructure.data.mappers.toDomain
import com.elitec.hightask.infraestructure.log.AppLogger
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.parameter
import io.ktor.client.request.patch
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.http.isSuccess

class JobsRepositoryImpl(
    private val httpClient: HttpClient
) : JobsRepository {
    private val projectId = InfrastructureInfo.AppWriteConfig.appWriteProjectId
    private val endpoint = InfrastructureInfo.AppWriteConfig.appWriteEndpoint
    private val databaseId = InfrastructureInfo.AppWriteConfig.appWriteDatabaseId
    private val tableId = InfrastructureInfo.AppWriteConfig.appWriteJobsTableId
    private val baseUrl =
        "https://$endpoint/databases/${databaseId}/collections/${tableId}/documents"

    private fun HttpRequestBuilder.appwriteHeaders() {
        contentType(ContentType.Application.Json)
        header("X-Appwrite-Project", projectId)
    }

    override suspend fun getAllJobs(): Result<List<Job>> =
        runCatching {
            val response = httpClient.get(baseUrl) {
                appwriteHeaders()
            }

            if (!response.status.isSuccess()) {
                val error = response.bodyAsText()
                AppLogger.launchError(
                    tag = "JobsRepository",
                    msg = "Appwrite error ${response.status}: $error"
                )
                error("Appwrite error ${response.status}")
            }

            val dto: AppwriteListDto<JobDto> = response.body()
            dto.documents.map { it.toDomain() }
        }

    override suspend fun getAllJobsByUser(userId: String): Result<List<Job>> =
        runCatching {
            val response: AppwriteListDto<JobDto> =
                httpClient.get(baseUrl) {
                    appwriteHeaders()
                    parameter("userId", userId)
                }.body()

            response.documents.map { doc -> doc.toDomain() }
        }

    override suspend fun getJobById(jobId: Long): Result<Job> =
        runCatching {
            val doc: AppwriteDocumentDto<JobDto> =
                httpClient.get("$baseUrl/$jobId") { appwriteHeaders() }.body()

            doc.toDomain()
        }

    override suspend fun saveJob(job: Job): Result<Unit> =
        runCatching {
            httpClient.post(baseUrl) {
                appwriteHeaders()
                setBody(AppwriteCreateDocumentDto(data = job.toDto()))
            }
            Unit
        }

    override suspend fun updateJob(jobId: Long, job: Job): Result<Unit> =
        runCatching {
            httpClient.patch("$baseUrl/$jobId") {
                appwriteHeaders()
                setBody(AppwriteUpdateDocumentDto(data = job.toDto()))
            }
            Unit
        }

    override suspend fun deleteJob(jobId: Long): Result<Unit> =
        runCatching {
            httpClient.delete("$baseUrl/$jobId") { appwriteHeaders() }
            Unit
        }
}