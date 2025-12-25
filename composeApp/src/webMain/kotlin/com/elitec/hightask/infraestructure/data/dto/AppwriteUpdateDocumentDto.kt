package com.elitec.hightask.infraestructure.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class AppwriteUpdateDocumentDto<T>(
    val data: T
)