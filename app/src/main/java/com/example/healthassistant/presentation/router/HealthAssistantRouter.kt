package com.example.healthassistant.presentation.router

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.healthassistant.presentation.features.cardDetails.CardDetails
import com.example.healthassistant.presentation.features.dashboard.Dashboard
import com.example.healthassistant.presentation.features.intro.Intro
import com.example.healthassistant.presentation.features.notifications.Notifications
import com.example.healthassistant.presentation.features.profile.Profile
import com.example.healthassistant.presentation.features.settings.Settings
import com.example.healthassistant.presentation.features.statistics.Statistics
import com.example.healthassistant.presentation.router.Destinations.ADD_RECORD_ROUTE
import com.example.healthassistant.presentation.router.Destinations.CARD_DETAILS_ROUTE
import com.example.healthassistant.presentation.router.Destinations.CardDetailArgs.CARD_ID
import com.example.healthassistant.presentation.router.Destinations.DASHBOARD_ROUTE
import com.example.healthassistant.presentation.router.Destinations.INTRO_ROUTE
import com.example.healthassistant.presentation.router.Destinations.NOTIFICATIONS_ROUTE
import com.example.healthassistant.presentation.router.Destinations.PROFILE_ROUTE
import com.example.healthassistant.presentation.router.Destinations.SETTINGS_ROUTE
import com.example.healthassistant.presentation.router.Destinations.STATISTICS_ROUTE

@Composable
fun HealthAssistantRouter(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = DASHBOARD_ROUTE
) {
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
                modifier,
                actions.navigateToDashboard,
                actions.navigateToDashboard,
                actions.navigateToDashboard,
                actions.navigateToDashboard,
                actions.navigateToDashboard
            )
        }
        composable(NOTIFICATIONS_ROUTE) {
            Notifications()
        }
        composable(ADD_RECORD_ROUTE) {
        }
        composable(
            route = "$CARD_DETAILS_ROUTE/{$CARD_ID}",
            arguments = listOf(navArgument(CARD_ID) { type = NavType.StringType })
        ) { backStackEntry ->
            val arguments = requireNotNull(backStackEntry.arguments)
            val cardId = arguments.getString(CARD_ID)
            CardDetails(cardId = cardId ?: "")
        }
        composable(SETTINGS_ROUTE) {
            Settings()
        }
        composable(PROFILE_ROUTE) { backStackEntry ->
            Profile(backStackEntry.arguments?.getString("userId"))
        }
        composable(STATISTICS_ROUTE) {
            Statistics()
        }
    }
}
