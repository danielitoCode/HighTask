package com.elitec.hightask.feacture.job.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class JobDto(
    val tittle: String,
    val description: String,
    val location: String,
    val photoUrl: String,
    val type: String,
    val state: String,

    @SerialName("\$id")
    val id: String
)