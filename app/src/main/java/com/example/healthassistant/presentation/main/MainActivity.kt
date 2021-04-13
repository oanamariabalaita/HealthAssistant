package com.example.healthassistant.presentation.main

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.example.healthassistant.presentation.theme.HealthAppTheme

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels {
        defaultViewModelProviderFactory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            HealthAppTheme {
                MainView(
                    onBackPressedDispatcher,
                    mainViewModel,
                    applicationContext
                )
            }
        }
    }
}
