package com.example.healthassistant.presentation.main

import android.content.Context
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.healthassistant.presentation.components.BottomBar
import com.example.healthassistant.presentation.components.MainSections
import com.example.healthassistant.presentation.components.Scaffold
import com.example.healthassistant.presentation.router.HealthAssistantRouter

@Composable
fun MainView(applicationContext: Context) {

    val tabs = remember { MainSections.values() }
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomBar(navController = navController, tabs = tabs) }
    ) { innerPaddingModifier ->
        HealthAssistantRouter(
            navController = navController,
            applicationContext = applicationContext,
            modifier = Modifier.padding(innerPaddingModifier)
        )
    }
}
