package com.example.healthassistant.presentation.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun HealthAppTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = HealthAppColors,
        typography = HealthAppTypography,
        shapes = HealthAppShapes,
        content = content
    )
}
