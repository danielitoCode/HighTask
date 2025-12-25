package com.elitec.hightask

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform