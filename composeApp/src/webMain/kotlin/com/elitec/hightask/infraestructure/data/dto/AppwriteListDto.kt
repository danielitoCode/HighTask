package com.elitec.hightask.infraestructure.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class AppwriteListDto<T>(
    val total: Int,
    val documents: List<T>
)