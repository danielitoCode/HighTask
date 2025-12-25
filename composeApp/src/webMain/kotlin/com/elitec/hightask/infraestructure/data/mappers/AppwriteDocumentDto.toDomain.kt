package com.elitec.hightask.infraestructure.data.mappers

import com.elitec.hightask.feacture.job.data.dto.JobDto
import com.elitec.hightask.feacture.job.domain.Job
import com.elitec.hightask.infraestructure.data.dto.AppwriteDocumentDto

fun AppwriteDocumentDto<JobDto>.toDomain() = Job(
    id = id,
    tittle = data.tittle,
    photoUrl = data.photoUrl,
    location = data.location,
    type = data.type,
    description = data.description,
    state = data.state
)