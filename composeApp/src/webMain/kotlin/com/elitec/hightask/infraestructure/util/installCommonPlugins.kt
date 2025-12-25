package com.elitec.hightask.infraestructure.util

import com.elitec.hightask.infraestructure.log.KtorAppLoggerAdapter
import io.ktor.client.HttpClientConfig
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

fun HttpClientConfig<*>.installCommonPlugins() {

    install(ContentNegotiation) {
        json(
            Json {
                ignoreUnknownKeys = true
                isLenient = true
            }
        )
    }
    val isDebug = true
    if (isDebug) {
        install(Logging) {
            logger = KtorAppLoggerAdapter
            level = LogLevel.ALL
        }
    }
}