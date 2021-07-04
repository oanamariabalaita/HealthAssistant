package com.example.healthassistant.presentation.components

import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.healthassistant.presentation.theme.HealthAppTheme

@Composable
fun DividerComponent(
    modifier: Modifier = Modifier,
    color: Color = HealthAppTheme.colors.uiBorder.copy(alpha = DIVIDER_ALPHA),
    thickness: Dp = 1.dp,
    startIndent: Dp = 0.dp
) {
    Divider(
        modifier = modifier,
        color = color,
        thickness = thickness,
        startIndent = startIndent
    )
}

private const val DIVIDER_ALPHA = 0.12f
