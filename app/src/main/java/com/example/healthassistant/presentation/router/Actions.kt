package com.example.healthassistant.presentation.router

import androidx.navigation.NavHostController

class Actions(navController: NavHostController) {
    val navigateToDashboard: () -> Unit = {
        navController.navigate(Destinations.DASHBOARD_ROUTE) {
            launchSingleTop = true
        }
    }
    val popBackStackAndNavigateToDashboard: () -> Unit = {
        navController.apply {
            popBackStack()
            navigate(Destinations.DASHBOARD_ROUTE)
        }
    }
    val navigateUp: () -> Unit = {
        navController.navigateUp()
    }
    val navigateBack: () -> Unit = {
        navController.popBackStack()
    }
}
