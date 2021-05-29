package com.example.healthassistant.presentation.router

import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate

class Actions(navController: NavHostController) {
    val navigateToDashboard: () -> Unit = {
        navController.navigate(Destinations.DASHBOARD_ROUTE) {
            launchSingleTop = true
        }
    }
    val navigateUp: () -> Unit = {
        navController.navigateUp()
    }
    val navigateBack: () -> Unit = {
        navController.popBackStack()
    }
}