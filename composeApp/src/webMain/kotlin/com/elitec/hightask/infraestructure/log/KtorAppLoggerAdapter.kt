package com.elitec.hightask.infraestructure.log

import io.ktor.client.plugins.logging.Logger

object KtorAppLoggerAdapter : Logger {
    private const val TAG = "Ktor"

    override fun log(message: String) {
        if (message.contains("Authorization")) return
        AppLogger.launchNetwork(
            tag = TAG,
            msg = message
        )
    }
}