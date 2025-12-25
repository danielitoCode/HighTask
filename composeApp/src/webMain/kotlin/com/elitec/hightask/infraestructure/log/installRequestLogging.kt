package com.elitec.hightask.infraestructure.log

import io.ktor.client.HttpClientConfig
import io.ktor.client.plugins.observer.ResponseObserver
import io.ktor.client.statement.request

fun HttpClientConfig<*>.installResponseLogging() {
    install(ResponseObserver) {
        onResponse { response ->
            AppLogger.launchNetwork(
                tag = "HTTP-RESPONSE",
                msg = """
                    ⬅️ ${response.status.value} ${response.request.url}
                """.trimIndent()
            )
        }
    }
}