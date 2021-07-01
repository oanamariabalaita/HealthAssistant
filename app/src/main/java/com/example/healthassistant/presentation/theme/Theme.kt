package com.example.healthassistant.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun HealthAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    colorPallet: ColorPallet = ColorPallet.BLUE,
    content: @Composable () -> Unit
) {
    val colors = when (colorPallet) {
        ColorPallet.OCEAN -> if (darkTheme) darkOceanColorPalette else lightOceanColorPalette
        ColorPallet.PURPLE -> if (darkTheme) darkPurpleColorPalette else lightPurpleColorPalette
        ColorPallet.BLUE -> if (darkTheme) darkBlueColorPalette else lightBlueColorPalette
    }
    val sysUiController = rememberSystemUiController()

    SideEffect {
        sysUiController.setSystemBarsColor(
            color = colors.uiBackground.copy(alpha = AlphaNearOpaque)
        )
    }

    ProvideHealthAppColors(colors) {
        MaterialTheme(
            colors = debugColors(darkTheme, colors),
            typography = AppTypography,
            shapes = AppShapes,
            content = content
        )
    }
}

@Composable
fun ProvideHealthAppColors(
    colors: HealthAppColors,
    content: @Composable () -> Unit
) {
    val colorPalette = remember { colors }
    colorPalette.update(colors)
    CompositionLocalProvider(LocalColors provides colorPalette, content = content)
}

private val LocalColors = staticCompositionLocalOf<HealthAppColors> {
    error("No ColorPalette provided")
}

object HealthAppTheme {
    val colors: HealthAppColors
        @Composable
        get() = LocalColors.current
}


@Stable
@SuppressWarnings("LongParameterList")
class HealthAppColors(
    gradient61: List<Color>,
    gradient62: List<Color>,
    gradient31: List<Color>,
    gradient32: List<Color>,
    gradient21: List<Color>,
    gradient22: List<Color>,
    gradient23: List<Color>,
    brand: Color,
    brandSecondary: Color,
    uiBackground: Color,
    uiBorder: Color,
    uiFloated: Color,
    interactivePrimary: List<Color> = gradient21,
    interactiveSecondary: List<Color> = gradient22,
    interactiveMask: List<Color> = gradient61,
    textPrimary: Color = brand,
    textSecondary: Color,
    textHelp: Color,
    textInteractive: Color,
    textLink: Color,
    tornado1: List<Color>,
    iconPrimary: Color = brand,
    iconSecondary: Color,
    iconInteractive: Color,
    iconInteractiveInactive: Color,
    error: Color,
    notificationBadge: Color = error,
    isDark: Boolean
) {
    var gradient61 by mutableStateOf(gradient61)
        private set
    var gradient62 by mutableStateOf(gradient62)
        private set
    var gradient31 by mutableStateOf(gradient31)
        private set
    var gradient32 by mutableStateOf(gradient32)
        private set
    var gradient21 by mutableStateOf(gradient21)
        private set
    var gradient22 by mutableStateOf(gradient22)
        private set
    var gradient23 by mutableStateOf(gradient23)
        private set
    var brand by mutableStateOf(brand)
        private set
    var brandSecondary by mutableStateOf(brandSecondary)
        private set
    var uiBackground by mutableStateOf(uiBackground)
        private set
    var uiBorder by mutableStateOf(uiBorder)
        private set
    var uiFloated by mutableStateOf(uiFloated)
        private set
    var interactivePrimary by mutableStateOf(interactivePrimary)
        private set
    var interactiveSecondary by mutableStateOf(interactiveSecondary)
        private set
    var interactiveMask by mutableStateOf(interactiveMask)
        private set
    var textPrimary by mutableStateOf(textPrimary)
        private set
    var textSecondary by mutableStateOf(textSecondary)
        private set
    var textHelp by mutableStateOf(textHelp)
        private set
    var textInteractive by mutableStateOf(textInteractive)
        private set
    var tornado1 by mutableStateOf(tornado1)
        private set
    var textLink by mutableStateOf(textLink)
        private set
    var iconPrimary by mutableStateOf(iconPrimary)
        private set
    var iconSecondary by mutableStateOf(iconSecondary)
        private set
    var iconInteractive by mutableStateOf(iconInteractive)
        private set
    var iconInteractiveInactive by mutableStateOf(iconInteractiveInactive)
        private set
    var error by mutableStateOf(error)
        private set
    var notificationBadge by mutableStateOf(notificationBadge)
        private set
    var isDark by mutableStateOf(isDark)
        private set

    fun update(other: HealthAppColors) {
        gradient61 = other.gradient61
        gradient62 = other.gradient62
        gradient31 = other.gradient31
        gradient32 = other.gradient32
        gradient21 = other.gradient21
        gradient22 = other.gradient22
        gradient23 = other.gradient23
        brand = other.brand
        brandSecondary = other.brandSecondary
        uiBackground = other.uiBackground
        uiBorder = other.uiBorder
        uiFloated = other.uiFloated
        interactivePrimary = other.interactivePrimary
        interactiveSecondary = other.interactiveSecondary
        interactiveMask = other.interactiveMask
        textPrimary = other.textPrimary
        textSecondary = other.textSecondary
        textHelp = other.textHelp
        textInteractive = other.textInteractive
        textLink = other.textLink
        tornado1 = other.tornado1
        iconPrimary = other.iconPrimary
        iconSecondary = other.iconSecondary
        iconInteractive = other.iconInteractive
        iconInteractiveInactive = other.iconInteractiveInactive
        error = other.error
        notificationBadge = other.notificationBadge
        isDark = other.isDark
    }
}

// dark palettes
private val darkOceanColorPalette = HealthAppColors(
    brand = Ocean10,
    brandSecondary = Ocean3,
    uiBackground = Neutral0,
    uiBorder = Neutral4,
    uiFloated = FunctionalGrey,
    textSecondary = Neutral7,
    textHelp = Neutral6,
    textInteractive = Neutral0,
    textLink = Ocean11,
    iconSecondary = Neutral7,
    iconInteractive = Neutral0,
    iconInteractiveInactive = Neutral1,
    error = FunctionalRed,
    gradient61 = listOf(Shadow4, Ocean3, Shadow2, Ocean3, Shadow4),
    gradient62 = listOf(Rose4, Lavender3, Rose2, Lavender3, Rose4),
    gradient31 = listOf(Shadow2, Ocean3, Shadow4),
    gradient32 = listOf(Rose2, Lavender3, Rose4),
    gradient21 = listOf(Shadow4, Shadow11),
    gradient22 = listOf(Ocean3, Shadow3),
    gradient23 = listOf(Lavender3, Rose2),
    tornado1 = listOf(Shadow4, Ocean3),
    isDark = false
)

private val darkPurpleColorPalette = HealthAppColors(
    brand = Ocean10,
    brandSecondary = Ocean3,
    uiBackground = Neutral0,
    uiBorder = Neutral4,
    uiFloated = FunctionalGrey,
    textSecondary = Neutral7,
    textHelp = Neutral6,
    textInteractive = Neutral0,
    textLink = Ocean11,
    iconSecondary = Neutral7,
    iconInteractive = Neutral0,
    iconInteractiveInactive = Neutral1,
    error = FunctionalRed,
    gradient61 = listOf(Shadow4, Ocean3, Shadow2, Ocean3, Shadow4),
    gradient62 = listOf(Rose4, Lavender3, Rose2, Lavender3, Rose4),
    gradient31 = listOf(Shadow2, Ocean3, Shadow4),
    gradient32 = listOf(Rose2, Lavender3, Rose4),
    gradient21 = listOf(Shadow4, Shadow11),
    gradient22 = listOf(Ocean3, Shadow3),
    gradient23 = listOf(Lavender3, Rose2),
    tornado1 = listOf(Shadow4, Ocean3),
    isDark = false
)

private val darkBlueColorPalette = HealthAppColors(
    brand = Ocean10,
    brandSecondary = Ocean3,
    uiBackground = Neutral0,
    uiBorder = Neutral4,
    uiFloated = FunctionalGrey,
    textSecondary = Neutral7,
    textHelp = Neutral6,
    textInteractive = Neutral0,
    textLink = Ocean11,
    iconSecondary = Neutral7,
    iconInteractive = Neutral0,
    iconInteractiveInactive = Neutral1,
    error = FunctionalRed,
    gradient61 = listOf(Shadow4, Ocean3, Shadow2, Ocean3, Shadow4),
    gradient62 = listOf(Rose4, Lavender3, Rose2, Lavender3, Rose4),
    gradient31 = listOf(Shadow2, Ocean3, Shadow4),
    gradient32 = listOf(Rose2, Lavender3, Rose4),
    gradient21 = listOf(Shadow4, Shadow11),
    gradient22 = listOf(Ocean3, Shadow3),
    gradient23 = listOf(Lavender3, Rose2),
    tornado1 = listOf(Shadow4, Ocean3),
    isDark = false
)

// Light pallets
private val lightOceanColorPalette = HealthAppColors(
    brand = Ocean10,
    brandSecondary = Ocean3,
    uiBackground = Neutral0,
    uiBorder = Neutral4,
    uiFloated = FunctionalGrey,
    textSecondary = Neutral7,
    textHelp = Neutral6,
    textInteractive = Neutral0,
    textLink = Ocean11,
    iconSecondary = Neutral7,
    iconInteractive = Neutral0,
    iconInteractiveInactive = Neutral1,
    error = FunctionalRed,
    gradient61 = listOf(Shadow4, Ocean3, Shadow2, Ocean3, Shadow4),
    gradient62 = listOf(Rose4, Lavender3, Rose2, Lavender3, Rose4),
    gradient31 = listOf(Shadow2, Ocean3, Shadow4),
    gradient32 = listOf(Rose2, Lavender3, Rose4),
    gradient21 = listOf(Shadow4, Shadow11),
    gradient22 = listOf(Ocean3, Shadow3),
    gradient23 = listOf(Lavender3, Rose2),
    tornado1 = listOf(Shadow4, Ocean3),
    isDark = false
)

private val lightPurpleColorPalette = HealthAppColors(
    brand = Ocean10,
    brandSecondary = Ocean3,
    uiBackground = Neutral0,
    uiBorder = Neutral4,
    uiFloated = FunctionalGrey,
    textSecondary = Neutral7,
    textHelp = Neutral6,
    textInteractive = Neutral0,
    textLink = Ocean11,
    iconSecondary = Neutral7,
    iconInteractive = Neutral0,
    iconInteractiveInactive = Neutral1,
    error = FunctionalRed,
    gradient61 = listOf(Shadow4, Ocean3, Shadow2, Ocean3, Shadow4),
    gradient62 = listOf(Rose4, Lavender3, Rose2, Lavender3, Rose4),
    gradient31 = listOf(Shadow2, Ocean3, Shadow4),
    gradient32 = listOf(Rose2, Lavender3, Rose4),
    gradient21 = listOf(Shadow4, Shadow11),
    gradient22 = listOf(Ocean3, Shadow3),
    gradient23 = listOf(Lavender3, Rose2),
    tornado1 = listOf(Shadow4, Ocean3),
    isDark = false
)

private val lightBlueColorPalette = HealthAppColors(
    brand = Ocean10,
    brandSecondary = Ocean3,
    uiBackground = Neutral0,
    uiBorder = Neutral4,
    uiFloated = FunctionalGrey,
    textSecondary = Neutral7,
    textHelp = Neutral6,
    textInteractive = Neutral0,
    textLink = Ocean11,
    iconSecondary = Neutral7,
    iconInteractive = Neutral0,
    iconInteractiveInactive = Neutral1,
    error = FunctionalRed,
    gradient61 = listOf(Shadow4, Ocean3, Shadow2, Ocean3, Shadow4),
    gradient62 = listOf(Rose4, Lavender3, Rose2, Lavender3, Rose4),
    gradient31 = listOf(Shadow2, Ocean3, Shadow4),
    gradient32 = listOf(Rose2, Lavender3, Rose4),
    gradient21 = listOf(Shadow4, Shadow11),
    gradient22 = listOf(Ocean3, Shadow3),
    gradient23 = listOf(Lavender3, Rose2),
    tornado1 = listOf(Shadow4, Ocean3),
    isDark = false
)

fun debugColors(
    darkTheme: Boolean,
    colors: HealthAppColors
) = Colors(
    primary = colors.iconPrimary,
    primaryVariant = colors.textPrimary,
    secondary = colors.iconSecondary,
    secondaryVariant = colors.textSecondary,
    background = colors.uiBackground,
    surface = colors.uiFloated,
    error = colors.error,
    onPrimary = colors.iconPrimary,
    onSecondary = colors.iconSecondary,
    onBackground = colors.uiBackground,
    onSurface = colors.uiFloated,
    onError = colors.error,
    isLight = !darkTheme
)
