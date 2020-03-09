package com.example.healthassistant.utils.navigation

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph
import androidx.navigation.get

class ToolbarNavigationHandler(
    private val toolbar: Toolbar,
    navController: NavController,
    private val topLevelDestinations: Set<Int> = setOf()
) : NavController.OnDestinationChangedListener {

    private val navigationIcon = toolbar.navigationIcon

    init {
        navController.addOnDestinationChangedListener(this)
    }

    override fun onDestinationChanged(
        controller: NavController,
        destination: NavDestination,
        arguments: Bundle?
    ) {
        toolbar.navigationIcon =
            if (shouldShowNavigationIcon(controller, destination)) navigationIcon
            else null
    }

    private fun shouldShowNavigationIcon(
        controller: NavController,
        destination: NavDestination
    ): Boolean {
        val graphStartDestination = controller.graph.startDestination

        if (destination.id == graphStartDestination || destination.id in topLevelDestinations) {
            return false
        }

        val startDestination = controller.graph[graphStartDestination]

        if (startDestination is NavGraph && startDestination.startDestination == destination.id) {
            return false
        }

        return true
    }
}