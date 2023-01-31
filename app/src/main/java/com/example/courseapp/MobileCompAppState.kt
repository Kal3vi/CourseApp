package com.example.courseapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

class MobileCompAppState(
    val navController: NavHostController
) {
    fun navigateBack() {
        navController.popBackStack()
    }
}

@Composable
fun rememberMobileCompAppState(
    navController: NavHostController = rememberNavController()
) = remember(navController) {
    MobileCompAppState(navController)
}