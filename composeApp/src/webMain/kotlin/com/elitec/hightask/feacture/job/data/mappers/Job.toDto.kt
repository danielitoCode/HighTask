package com.elitec.hightask.feacture.job.data.mappers

import com.elitec.hightask.feacture.job.data.dto.JobDto
import com.elitec.hightask.feacture.job.domain.Job

fun Job.toDto() = JobDto(
    tittle = tittle,
    photoUrl = photoUrl,
    location = location,
    type = type,
    description = description,
    state = state,
    id = id
)