package com.example.healthassistant.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.healthassistant.presentation.features.dashboard.Dashboard
import com.example.healthassistant.presentation.features.intro.Intro

object MainDestinations {
    const val INTRO_ROUTE = "intro"
    const val DASHBOARD_ROUTE = "dashboard"
}

@Composable
fun NavGraph(startDestination: String = MainDestinations.INTRO_ROUTE) {
    val navController = rememberNavController()

    val actions = remember(navController) { MainActions(navController) }
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(MainDestinations.INTRO_ROUTE) {
            Intro(introComplete = actions.introComplete)
        }
        composable(MainDestinations.DASHBOARD_ROUTE) {
            Dashboard()
        }
    }
}

class MainActions(navController: NavHostController) {
    val introComplete: () -> Unit = {
        navController.navigate(MainDestinations.DASHBOARD_ROUTE)
    }
    val upPress: () -> Unit = {
        navController.navigateUp()
    }
}
