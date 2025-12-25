package com.elitec.hightask.feacture.job.di

import com.elitec.hightask.feacture.job.data.net.JobsRepositoryImpl
import com.elitec.hightask.feacture.job.domain.GetAllJobsByUserIdCaseUse
import com.elitec.hightask.feacture.job.domain.GetAllJobsCaseUse
import com.elitec.hightask.feacture.job.domain.JobsRepository
import com.elitec.hightask.feacture.job.presenntation.JobsViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

fun jobsModule(): Module = module {
    // Data layer
    single<JobsRepository> { JobsRepositoryImpl(get()) }

    // Domain layer
    single { GetAllJobsCaseUse(get()) }
    single { GetAllJobsByUserIdCaseUse(get()) }

    // Presentation layer
    viewModel { JobsViewModel(get(), get()) }
}