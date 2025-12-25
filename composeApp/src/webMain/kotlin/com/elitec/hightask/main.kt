package com.elitec.hightask

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import com.elitec.hightask.feacture.job.di.jobsModule
import com.elitec.hightask.infraestructure.di.networkModules
import com.elitec.hightask.infraestructure.log.AppLogger
import org.koin.core.context.startKoin

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    AppLogger.init(debug = true)
    startKoin {
        modules(
            networkModules(),
            jobsModule()
        )
    }
    ComposeViewport {
        App()
    }
}