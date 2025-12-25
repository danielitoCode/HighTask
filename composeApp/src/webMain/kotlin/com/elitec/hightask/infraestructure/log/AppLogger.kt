package com.elitec.hightask.infraestructure.log

import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.collections.plus
import kotlin.time.ExperimentalTime

object AppLogger {

    private val _logs = MutableStateFlow<List<LogEntry>>(emptyList())
    val logs = _logs.asStateFlow()

    fun init(debug: Boolean = true) {
        if (debug) Napier.base(DebugAntilog())
        launchInfo("Logger", "Sistema de logs inicializado")
    }

    /* ================= API PUBLICA ================= */

    fun launchDebug(tag: String, msg: String) =
        emit(LogType.DEBUG, "🐛", tag, msg) { Napier.d(it) }

    fun launchInfo(tag: String, msg: String) =
        emit(LogType.INFO, "ℹ️", tag, msg) { Napier.i(it) }

    fun launchWarn(tag: String, msg: String) =
        emit(LogType.WARN, "⚠️", tag, msg) { Napier.w(it) }

    fun launchError(tag: String, msg: String, e: Throwable? = null) =
        emit(LogType.ERROR, "❌", tag, msg) { Napier.e(it, e) }

    fun launchSuccess(tag: String, msg: String) =
        emit(LogType.SUCCESS, "✅", tag, msg) { Napier.i(it) }

    fun launchEvent(tag: String, msg: String) =
        emit(LogType.EVENT, "📡", tag, msg) { Napier.i(it) }

    fun launchSecurity(tag: String, msg: String) =
        emit(LogType.SECURITY, "🔐", tag, msg) { Napier.w(it) }

    fun launchNetwork(tag: String, msg: String) =
        emit(LogType.NETWORK, "🌐", tag, msg) { Napier.d(it) }

    /* ================= CORE ================= */

    fun testLogs() {
        launchDebug("AppLogger-> Test","Debug test")
        launchInfo("AppLogger-> Test","Info test")
        launchWarn("AppLogger-> Test","Warn test")
        launchError("AppLogger-> Test","Error test")
        launchSuccess("AppLogger-> Test","Success test")
        launchEvent("AppLogger-> Test","Event test")
        launchSecurity("AppLogger-> Test","Security test")
        launchNetwork("AppLogger-> Test","Network test")
    }
    @OptIn(ExperimentalTime::class)
    private inline fun emit(
        type: LogType,
        emoji: String,
        tag: String,
        msg: String,
        console: (String) -> Unit
    ) {
        val formatted = "$emoji [$tag] $msg"
        console(formatted)

        _logs.value + LogEntry(
            type = type,
            tag = tag,
            message = msg
        )
    }
}
