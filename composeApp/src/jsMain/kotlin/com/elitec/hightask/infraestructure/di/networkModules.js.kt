package com.elitec.hightask.infraestructure.di

import com.elitec.hightask.infraestructure.util.installCommonPlugins
import io.ktor.client.HttpClient
import io.ktor.client.engine.js.Js
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun networkModules(): Module = module {
    single { HttpClient(Js) {
        installCommonPlugins()
    } }
}