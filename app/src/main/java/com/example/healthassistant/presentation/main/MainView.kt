package com.example.healthassistant.presentation.main

import android.content.Context
import androidx.activity.OnBackPressedDispatcher
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.example.healthassistant.presentation.router.LocalBackDispatcher
import com.example.healthassistant.presentation.router.NavGraph

@Composable
fun MainView(
    backDispatcher: OnBackPressedDispatcher,
    viewModel: MainViewModel,
    applicationContext: Context
) {

    CompositionLocalProvider(LocalBackDispatcher provides backDispatcher) {
        NavGraph(applicationContext)
    }
}
