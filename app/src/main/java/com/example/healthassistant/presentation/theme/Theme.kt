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
    colorPallet: ColorPallet = ColorPallet.OCEAN,
    content: @Composable () -> Unit
) {
    val colors = when (colorPallet) {
        ColorPallet.OCEAN -> if (darkTheme) darkOceanColorPalette else lightOceanColorPalette
        ColorPallet.PURPLE -> if (darkTheme) darkPurpleColorPalette else lightPurpleColorPalette
        ColorPallet.BLUE -> if (darkTheme) darkBlueColorPalette else lightBlueColorPalette
    }
    val sysUiController = rememberSystemUiController()

    SideEffect {
        sysUiController.setStatusBarColor(color = colors.baseColors.primary)
        sysUiController.setNavigationBarColor(
            color = colors.baseColors.primary.copy(alpha = AlphaNearTransparent)
        )
    }

    ProvideHealthAppColors(colors) {
        MaterialTheme(
            colors = colors.baseColors,
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
    brandSecondary: Color,
    uiBorder: Color,
    uiFloated: Color,
    textPrimary: Color,
    textSecondary: Color,
    textHelp: Color,
    textInteractive: Color,
    textLink: Color,
    iconPrimary: Color,
    iconSecondary: Color,
    iconInteractive: Color,
    iconInteractiveInactive: Color,
    notificationBadge: Color,
    primary: Color,
    primaryVariant: Color,
    secondary: Color,
    secondaryVariant: Color,
    background: Color,
    surface: Color,
    error: Color,
    onPrimary: Color,
    onSecondary: Color,
    onBackground: Color,
    onSurface: Color,
    onError: Color,
    isLight: Boolean
) {
    var brandSecondary by mutableStateOf(brandSecondary)
        private set
    var uiBorder by mutableStateOf(uiBorder)
        private set
    var uiFloated by mutableStateOf(uiFloated)
        private set
    var textPrimary by mutableStateOf(textPrimary)
        private set
    var textSecondary by mutableStateOf(textSecondary)
        private set
    var textHelp by mutableStateOf(textHelp)
        private set
    var textInteractive by mutableStateOf(textInteractive)
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
    var notificationBadge by mutableStateOf(notificationBadge)
        private set
    var baseColors by mutableStateOf(
        Colors(
            primary = primary,
            primaryVariant = primaryVariant,
            secondary = secondary,
            secondaryVariant = secondaryVariant,
            background = background,
            surface = surface,
            error = error,
            onPrimary = onPrimary,
            onSecondary = onSecondary,
            onBackground = onBackground,
            onSurface = onSurface,
            onError = onError,
            isLight = isLight
        )
    )
        private set

    fun update(other: HealthAppColors) {
        brandSecondary = other.brandSecondary
        uiBorder = other.uiBorder
        uiFloated = other.uiFloated
        textPrimary = other.textPrimary
        textSecondary = other.textSecondary
        textHelp = other.textHelp
        textInteractive = other.textInteractive
        textLink = other.textLink
        iconPrimary = other.iconPrimary
        iconSecondary = other.iconSecondary
        iconInteractive = other.iconInteractive
        iconInteractiveInactive = other.iconInteractiveInactive
        notificationBadge = other.notificationBadge
        baseColors = other.baseColors
    }
}

// dark palettes
private val darkOceanColorPalette = HealthAppColors(
    brandSecondary = Ocean3,
    uiBorder = Neutral4,
    uiFloated = FunctionalGrey,
    textPrimary = Neutral8,
    textSecondary = Neutral7,
    textHelp = Neutral6,
    textInteractive = Neutral0,
    textLink = Ocean11,
    iconPrimary = Ocean10,
    iconSecondary = Neutral7,
    iconInteractive = Neutral0,
    iconInteractiveInactive = Neutral1,
    notificationBadge = FunctionalGreen,
    primary = GreenDarkPrimary,
    primaryVariant = Ocean9,
    secondary = Blue8,
    secondaryVariant = Blue9,
    background = Color.White,
    surface = Color.White,
    error = FunctionalRed,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Color.Black,
    onSurface = Color.Black,
    onError = Color.White,
    isLight = false
)

private val darkPurpleColorPalette = HealthAppColors(
    brandSecondary = Ocean3,
    uiBorder = Neutral4,
    uiFloated = FunctionalGrey,
    textPrimary = Neutral8,
    textSecondary = Neutral7,
    textHelp = Neutral6,
    textInteractive = Neutral0,
    textLink = Ocean11,
    iconPrimary = Ocean10,
    iconSecondary = Neutral7,
    iconInteractive = Neutral0,
    iconInteractiveInactive = Neutral1,
    notificationBadge = Ocean8,
    primary = Ocean8,
    primaryVariant = Ocean8,
    secondary = Ocean8,
    secondaryVariant = Ocean8,
    background = Ocean8,
    surface = Ocean8,
    error = FunctionalRed,
    onPrimary = Ocean8,
    onSecondary = Ocean8,
    onBackground = Ocean8,
    onSurface = Ocean8,
    onError = Ocean8,
    isLight = false
)

private val darkBlueColorPalette = HealthAppColors(
    brandSecondary = Ocean3,
    uiBorder = Neutral4,
    uiFloated = FunctionalGrey,
    textPrimary = Neutral8,
    textSecondary = Neutral7,
    textHelp = Neutral6,
    textInteractive = Neutral0,
    textLink = Ocean11,
    iconPrimary = Ocean10,
    iconSecondary = Neutral7,
    iconInteractive = Neutral0,
    iconInteractiveInactive = Neutral1,
    notificationBadge = FunctionalGreen,
    primary = Ocean8,
    primaryVariant = Ocean9,
    secondary = Blue8,
    secondaryVariant = Blue9,
    background = Color.White,
    surface = Color.White,
    error = FunctionalRed,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Color.Black,
    onSurface = Color.Black,
    onError = Color.White,
    isLight = false
)

// Light pallets
private val lightOceanColorPalette = HealthAppColors(
    brandSecondary = Ocean3,
    uiBorder = Neutral4,
    uiFloated = FunctionalGrey,
    textPrimary = Neutral8,
    textSecondary = Neutral7,
    textHelp = Neutral6,
    textInteractive = Neutral0,
    textLink = Ocean11,
    iconPrimary = Ocean10,
    iconSecondary = Neutral7,
    iconInteractive = Neutral0,
    iconInteractiveInactive = Neutral1,
    notificationBadge = Ocean8,
    primary = Ocean8,
    primaryVariant = Ocean8,
    secondary = Ocean8,
    secondaryVariant = Ocean8,
    background = Ocean8,
    surface = Ocean8,
    error = FunctionalRed,
    onPrimary = Ocean8,
    onSecondary = Ocean8,
    onBackground = Ocean8,
    onSurface = Ocean8,
    onError = Ocean8,
    isLight = false
)

private val lightPurpleColorPalette = HealthAppColors(
    brandSecondary = Ocean3,
    uiBorder = Neutral4,
    uiFloated = FunctionalGrey,
    textPrimary = Neutral8,
    textSecondary = Neutral7,
    textHelp = Neutral6,
    textInteractive = Neutral0,
    textLink = Ocean11,
    iconPrimary = Ocean10,
    iconSecondary = Neutral7,
    iconInteractive = Neutral0,
    iconInteractiveInactive = Neutral1,
    notificationBadge = Ocean8,
    primary = Ocean8,
    primaryVariant = Ocean8,
    secondary = Ocean8,
    secondaryVariant = Ocean8,
    background = Ocean8,
    surface = Ocean8,
    error = FunctionalRed,
    onPrimary = Ocean8,
    onSecondary = Ocean8,
    onBackground = Ocean8,
    onSurface = Ocean8,
    onError = Ocean8,
    isLight = false
)

private val lightBlueColorPalette = HealthAppColors(
    brandSecondary = Ocean3,
    uiBorder = Neutral4,
    uiFloated = FunctionalGrey,
    textPrimary = Neutral8,
    textSecondary = Neutral7,
    textHelp = Neutral6,
    textInteractive = Neutral0,
    textLink = Ocean11,
    iconPrimary = Ocean10,
    iconSecondary = Neutral7,
    iconInteractive = Neutral0,
    iconInteractiveInactive = Neutral1,
    notificationBadge = Ocean8,
    primary = Ocean8,
    primaryVariant = Ocean8,
    secondary = Ocean8,
    secondaryVariant = Ocean8,
    background = Ocean8,
    surface = Ocean8,
    error = FunctionalRed,
    onPrimary = Ocean8,
    onSecondary = Ocean8,
    onBackground = Ocean8,
    onSurface = Ocean8,
    onError = Ocean8,
    isLight = false
)
