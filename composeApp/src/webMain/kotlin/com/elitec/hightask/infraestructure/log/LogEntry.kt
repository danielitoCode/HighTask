package com.elitec.hightask.infraestructure.log

import kotlin.time.Clock
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

data class LogEntry @OptIn(ExperimentalTime::class) constructor(
    val timestamp: Instant = Clock.System.now(),
    val type: LogType,
    val tag: String,
    val message: String
)