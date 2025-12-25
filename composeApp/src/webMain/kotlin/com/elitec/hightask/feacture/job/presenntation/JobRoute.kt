package com.elitec.hightask.feacture.job.presenntation

import kotlinx.serialization.Serializable

@Serializable
data class JobRoute(
    val userId: String,
    val role: String
)