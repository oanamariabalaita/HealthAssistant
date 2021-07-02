package com.example.healthassistant.presentation.components

import androidx.annotation.StringRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.healthassistant.R
import com.example.healthassistant.presentation.router.Destinations
import com.example.healthassistant.presentation.theme.HealthAppTheme

@Composable
fun BottomBar(
    navController: NavController,
    tabs: Array<MainSections>,
    color: Color = HealthAppTheme.colors.iconPrimary,
) {
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.background,
        contentColor = color,
        elevation = 4.dp
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        tabs.forEach {
            val selected = currentRoute == it.route
            val tint by animateColorAsState(
                if (selected) {
                    Color.Green
                } else {
                    Color.Yellow
                }
            )
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = it.icon,
                        tint = tint,
                        contentDescription = null
                    )
                },
                selected = selected,
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(alpha = 0.4f),
                onClick = {
                    if (it.route != currentRoute) {
                        navController.navigate(it.route) {
                            restoreState = true
                            launchSingleTop = true
                        }
                    }
                }
            )
        }
    }
}

enum class MainSections(
    @StringRes val title: Int,
    val icon: ImageVector,
    val route: String
) {
    DASHBOARD(
        R.string.bottom_menu_home,
        Icons.Outlined.Home,
        Destinations.DASHBOARD_ROUTE
    ),
    STATISTICS(
        R.string.bottom_menu_statistics,
        Icons.Outlined.Search,
        Destinations.STATISTICS_ROUTE
    ),
    SETTINGS(
        R.string.bottom_menu_settings,
        Icons.Outlined.ShoppingCart,
        Destinations.SETTINGS_ROUTE
    ),
    PROFILE(
        R.string.bottom_menu_profile,
        Icons.Outlined.AccountCircle,
        Destinations.PROFILE_ROUTE
    )
}
