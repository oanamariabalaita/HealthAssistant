package com.example.healthassistant.presentation.theme

import androidx.compose.material.Colors
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver

enum class ColorPallet {
    PURPLE, GREEN, ORANGE, BLUE
}

@Composable
fun Colors.compositedOnSurface(alpha: Float): Color {
    return onSurface.copy(alpha = alpha).compositeOver(surface)
}

// dark palettes
val DarkGreenColorPalette = darkColors(
    primary = Color.Cyan,
    primaryVariant = Color.Green,
    secondary = Color.Red,
    background = Color.Black,
    surface = Color.Black,
    onPrimary = Color.Black,
    onBackground = Color.White,
    onSurface = Color.White,
    error = Color.Red,
)

val DarkPurpleColorPalette = darkColors(
    background = Color.Black,
    surface = Color.Black,
    onPrimary = Color.Black,
    onSecondary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White,
    error = Color.Red,
    onError = Color.Red
)

val DarkBlueColorPalette = darkColors(
    background = Color.Black,
    surface = Color.Black,
    onPrimary = Color.Black,
    onSecondary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White,
    error = Color.Red,
    onError = Color.Red
)

val DarkOrangeColorPalette = darkColors(
    background = Color.Black,
    surface = Color.Black,
    onPrimary = Color.Black,
    onSecondary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White,
    error = Color.Red,
    onError = Color.Red
)

// Light pallets
val LightGreenColorPalette = lightColors(
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    onError = Color.Red
)

val LightPurpleColorPalette = lightColors(
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    onError = Color.Red
)

val LightBlueColorPalette = lightColors(
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    onError = Color.Red
)

val LightOrangeColorPalette = lightColors(
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    onError = Color.Red
)

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

val purple200 = Color(0xFF8E58EE)
val purple700 = Color(0xFF794FC5)
val purple800 = Color(0xFF542E96)
val purpleDarkPrimary = Color(0xFF351F5C)


val teal200 = Color(0xff80deea)
val twitterColor = Color(0xFF1DA1F2)
val tiktokBlue = Color(0xFF69C9D0)
val tiktokRed = Color(0xFFEE1D52)
val tiktokBlack = Color(0xFF010101)
val blue = Color(0xFF5851DB)

val orange = Color(0xFFF56040)
val yellow = Color(0xFFFCAF45)
val graySurface = Color(0xFF2A2A2A)
val gradientGreenColors = listOf(green200, green700, green800)
val gradientRedColors = listOf(orange, tiktokRed)
val gradientBluePurple = listOf(blue, purple200)
val instagramGradient = listOf(blue, purple200, orange, yellow)

val blue1 = Color(0xFF37ECBA)
val blue2 = Color(0xFF54CEC6)
val blue3 = Color(0xFF72AFD3)
val blue4 = Color(0xFF27B9E3)
val blue5 = Color(0xCC3CB2E2)
val blue6 = Color(0xFF0D88AF)
val blue7 = Color(0xFF0B5D89)
