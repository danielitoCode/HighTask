package com.elitec.hightask.infraestructure.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class AppwriteDocumentResponse<T>(
    val id: String,
    val data: T
)