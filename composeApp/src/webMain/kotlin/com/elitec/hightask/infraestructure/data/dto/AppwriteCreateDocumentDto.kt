package com.elitec.hightask.infraestructure.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class AppwriteCreateDocumentDto<T>(
    val documentId: String = "unique()",
    val data: T
)