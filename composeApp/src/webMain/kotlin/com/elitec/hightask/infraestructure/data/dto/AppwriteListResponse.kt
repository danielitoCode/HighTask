package com.elitec.hightask.infraestructure.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class AppwriteListResponse<T>(
    val documents: List<AppwriteDocumentResponse<T>>
)