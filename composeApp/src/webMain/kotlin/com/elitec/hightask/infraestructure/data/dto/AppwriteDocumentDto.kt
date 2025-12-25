package com.elitec.hightask.infraestructure.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AppwriteDocumentDto<T>(
    @SerialName("\$id") val id: String,
    val data: T
)
