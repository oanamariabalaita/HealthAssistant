package com.example.healthassistant.presentation.main

import androidx.activity.OnBackPressedDispatcher
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.example.healthassistant.presentation.NavGraph
import com.example.healthassistant.presentation.utils.LocalBackDispatcher

@Composable
fun MainView(backDispatcher: OnBackPressedDispatcher, viewModel: MainViewModel) {

    CompositionLocalProvider(LocalBackDispatcher provides backDispatcher) {
        NavGraph()
    }
}
