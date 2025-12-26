package com.elitec.hightask.infraestructure.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.elitec.hightask.infraestructure.ui.screen.SplashScreen

@Composable
fun MainNavigationWrapper(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        modifier = modifier.fillMaxSize(),
        startDestination = Splash
    ) {
        composable<Splash> {
            SplashScreen(
                navigateTo = { navController.navigate(Login) },
                modifier = Modifier.fillMaxSize()
            )
        }
        composable<Login> {

        }
    }
}