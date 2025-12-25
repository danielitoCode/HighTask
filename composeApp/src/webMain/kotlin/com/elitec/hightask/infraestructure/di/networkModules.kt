package com.elitec.hightask.infraestructure.di

import io.ktor.client.HttpClient
import org.koin.core.module.Module
import org.koin.dsl.module

expect fun networkModules(): Module