package com.example.healthassistant.presentation.router

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.healthassistant.presentation.features.cardDetails.CardDetails
import com.example.healthassistant.presentation.features.dashboard.Dashboard
import com.example.healthassistant.presentation.features.intro.Intro
import com.example.healthassistant.presentation.router.Destinations.ADD_RECORD_ROUTE
import com.example.healthassistant.presentation.router.Destinations.CARD_DETAILS_ROUTE
import com.example.healthassistant.presentation.router.Destinations.CardDetailArgs.CardId
import com.example.healthassistant.presentation.router.Destinations.DASHBOARD_ROUTE
import com.example.healthassistant.presentation.router.Destinations.INTRO_ROUTE
import com.example.healthassistant.presentation.router.Destinations.NOTIFICATIONS_ROUTE
import com.example.healthassistant.presentation.router.Destinations.PROFILE_ROUTE
import com.example.healthassistant.presentation.router.Destinations.SETTINGS_ROUTE
import com.example.healthassistant.presentation.router.Destinations.STATISTICS_ROUTE

@Composable
fun HealthAssistantRouter(
    applicationContext: Context,
    startDestination: String = DASHBOARD_ROUTE
) {
    val navController = rememberNavController()
    val actions = remember(navController) { Actions(navController) }

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(INTRO_ROUTE) {
            Intro(navigateToDashboard = actions.navigateToDashboard)
        }
        composable(DASHBOARD_ROUTE) {
            Dashboard(
                applicationContext,
                actions.navigateToDashboard,
                actions.navigateToDashboard,
                actions.navigateToDashboard,
                actions.navigateToDashboard
            )
        }
        composable(NOTIFICATIONS_ROUTE) {
        }
        composable(ADD_RECORD_ROUTE) {
        }
        composable(
            route = CARD_DETAILS_ROUTE,
            arguments = listOf(navArgument(CardId) { type = NavType.StringType })
        ) { backStackEntry ->
            CardDetails(
                cardId = backStackEntry.arguments?.getString(CardId) ?: "",
                navigateBack = actions.navigateBack
            )
        }
        composable(SETTINGS_ROUTE) {
        }
        composable(PROFILE_ROUTE) {
        }
        composable(STATISTICS_ROUTE) {
        }
    }
}
