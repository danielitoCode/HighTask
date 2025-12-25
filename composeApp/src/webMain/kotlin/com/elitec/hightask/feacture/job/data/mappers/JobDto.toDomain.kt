package com.elitec.hightask.feacture.job.data.mappers

import com.elitec.hightask.feacture.job.data.dto.JobDto
import com.elitec.hightask.feacture.job.domain.Job

fun JobDto.toDomain(): Job =
    Job (
        id = id,
        tittle = tittle,
        description = description,
        location = location,
        photoUrl = photoUrl,
        type = type,
        state = state
    )