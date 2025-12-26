package com.elitec.hightask.infraestructure.ui.navigation

import kotlinx.serialization.Serializable

@Serializable
object Splash: MainScreen

@Serializable
object Login: MainScreen

@Serializable
data class Home(
    val userId: String,
    val role: String
)