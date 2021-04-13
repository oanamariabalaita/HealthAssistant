package com.example.healthassistant.presentation.main

import android.content.Context
import androidx.activity.OnBackPressedDispatcher
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.example.healthassistant.presentation.router.HealthAssistantRouter
import com.example.healthassistant.presentation.utils.LocalBackDispatcher

@Composable
fun MainView(
    backDispatcher: OnBackPressedDispatcher,
    mainViewModel: MainViewModel,
    applicationContext: Context
) {
    CompositionLocalProvider(
        LocalBackDispatcher provides backDispatcher
    ) {
        HealthAssistantRouter(applicationContext)
    }
}
