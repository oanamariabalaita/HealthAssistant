package com.example.healthassistant.presentation.theme

import androidx.compose.material.Colors
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver

@Composable
fun Colors.compositedOnSurface(alpha: Float): Color {
    return onSurface.copy(alpha = alpha).compositeOver(surface)
}

val yellow200 = Color(0xffffeb46)
val yellow400 = Color(0xffffc000)
val yellow500 = Color(0xffffde03)
val yellow800 = Color(0xFFF29F05)
val yellowDarkPrimary = Color(0xff242316)

val green200 = Color(0xFF44B3E6)
val green700 = Color(0xFF0A93D1)
val green800 = Color(0xFF0981B8)
val greenDarkPrimary = Color(0xFF073A52)

val blue200 = Color(0xFF4080FF)
val blue700 = Color(0xff0336ff)
val blue800 = Color(0xff0035c9)
val blueDarkPrimary = Color(0xff1c1d24)

val HealthAppColors = darkColors(
    primary = green700,
    onPrimary = Color.Black,
    primaryVariant = yellow800,
    secondary = yellow800,
    onSecondary = Color.Black,
    error = yellowDarkPrimary,
    onError = Color.Black
)
