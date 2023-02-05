package com.example.courseapp.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.courseapp.ui.home.Home
import com.example.courseapp.ui.payment.Payment
import com.example.courseapp.ui.login.Login

@Composable
fun MobileCompApp(
    appState: MobileCompAppState = rememberMobileCompAppState()
) {
    NavHost(
        navController = appState.navController,
        startDestination = "login"
    ) {
        composable(route = "login") {
            Login(navController = appState.navController)
        }
        composable(route = "home") {
            Home(
                navController = appState.navController
            )
        }
        composable(route = "payment") {
            Payment(onBackPress = appState::navigateBack)
        }
    }
}