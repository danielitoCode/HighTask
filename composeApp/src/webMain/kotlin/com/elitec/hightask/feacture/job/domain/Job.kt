package com.elitec.hightask.feacture.job.domain

data class Job(
    val id: String,
    val tittle: String,
    val description: String,
    val location: String,
    val photoUrl: String,
    val type: String,
    val state: String
)