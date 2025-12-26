package com.elitec.hightask.infraestructure.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.elitec.hightask.infraestructure.ui.components.LoadingDots
import com.elitec.hightask.infraestructure.ui.navigation.MainScreen
import hightask.composeapp.generated.resources.Res
import hightask.composeapp.generated.resources.logo
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.painterResource

@Composable
fun SplashScreen(
    navigateTo: () -> Unit,
    // initializationViewModel: InitializationViewModel,
    modifier: Modifier = Modifier
) {
    val scope = rememberCoroutineScope()
    LaunchedEffect(null) {

        delay(2000)
        navigateTo()

        /*initializationViewModel.isFirstUse(
            isFirstCharge = {
                scope.launch {
                    delay(2000)
                    navigateTo(OnBoarding)
                }
            },
            notFirstCharge = {
                scope.launch {
                    delay(2000)
                    navigateTo(Presentation)
                }
            }
        )*/
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(Res.drawable.logo),
                contentDescription = "Logo App",
                modifier = Modifier.size(200.dp)
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(5.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    color = MaterialTheme.colorScheme.onBackground,
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    text = "High Task"
                )
                Text(
                    color = MaterialTheme.colorScheme.onBackground,
                    text = "Version Alfa-0.1"
                )
            }
            // 🔥 Loader animado
            LoadingDots()
        }
    }
}