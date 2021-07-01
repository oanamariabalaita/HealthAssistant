package com.example.healthassistant.presentation.components

import androidx.annotation.FloatRange
import androidx.annotation.StringRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.SpringSpec
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.MeasureResult
import androidx.compose.ui.layout.MeasureScope
import androidx.compose.ui.layout.Placeable
import androidx.compose.ui.layout.ScaleFactor
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.layout.lerp
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.healthassistant.R
import com.example.healthassistant.presentation.router.Destinations
import com.example.healthassistant.presentation.theme.HealthAppTheme

@Composable
fun BottomBar(
    navController: NavController,
    tabs: Array<MainSections>,
    color: Color = HealthAppTheme.colors.iconPrimary,
    contentColor: Color = HealthAppTheme.colors.iconInteractive
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.navigatorName
    val sections = remember { MainSections.values() }
    val routes = remember { sections.map { it.route } }

    if (currentRoute in routes) {
        val currentSection = sections.first { it.route == currentRoute }
        Surface(
            color = color,
            contentColor = contentColor
        ) {
            val springSpec = SpringSpec<Float>(
                // Determined experimentally
                stiffness = 800f,
                dampingRatio = 0.8f
            )
            BottomNavigationLayout(
                selectedIndex = currentSection.ordinal,
                itemCount = routes.size,
                indicator = { BottomNavigationIndicator() },
                animSpec = springSpec
            ) {
                tabs.forEach { section ->
                    val selected = section == currentSection
                    val tint by animateColorAsState(
                        if (selected) {
                            HealthAppTheme.colors.iconInteractive
                        } else {
                            HealthAppTheme.colors.iconInteractiveInactive
                        }
                    )

                    BottomNavigationItem(
                        icon = {
                            Icon(
                                imageVector = section.icon,
                                tint = tint,
                                contentDescription = null
                            )
                        },
                        text = {
                            Text(
                                text = stringResource(section.title),
                                color = tint,
                                style = MaterialTheme.typography.button,
                                maxLines = 1
                            )
                        },
                        selected = selected,
                        onSelected = {
                            if (section.route != currentRoute) {
                                navController.navigate(section.route) {
                                    launchSingleTop = true
                                }
                            }
                        },
                        animSpec = springSpec,
                        modifier = BottomNavigationItemPadding
                            .clip(BottomNavIndicatorShape)
                    )
                }
            }
        }
    }
}

@Composable
fun BottomNavigationItem(
    icon: @Composable BoxScope.() -> Unit,
    text: @Composable BoxScope.() -> Unit,
    selected: Boolean,
    onSelected: () -> Unit,
    animSpec: AnimationSpec<Float>,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.selectable(selected = selected, onClick = onSelected),
        contentAlignment = Alignment.Center
    ) {
        // Animate the icon/text positions within the item based on selection
        val animationProgress by animateFloatAsState(if (selected) 1f else 0f, animSpec)
        BottomNavigationItemLayout(
            icon = icon,
            text = text,
            animationProgress = animationProgress
        )
    }
}

@Composable
private fun BottomNavigationItemLayout(
    icon: @Composable BoxScope.() -> Unit,
    text: @Composable BoxScope.() -> Unit,
    @FloatRange(from = 0.0, to = 1.0) animationProgress: Float
) {
    Layout(
        content = {
            Box(
                modifier = Modifier
                    .layoutId("icon")
                    .padding(horizontal = TextIconSpacing),
                content = icon
            )
            val scale = lerp(ScaleFactor(0.6f, 0f), ScaleFactor(0f, 1f), animationProgress)
            Box(
                modifier = Modifier
                    .layoutId("text")
                    .padding(horizontal = TextIconSpacing)
                    .graphicsLayer {
                        alpha = animationProgress
                        scaleX = 0.6f
                        scaleY = 1f
                        transformOrigin = BottomNavLabelTransformOrigin
                    },
                content = text
            )
        }
    ) { measurables, constraints ->
        val iconPlaceable = measurables.first { it.layoutId == "icon" }.measure(constraints)
        val textPlaceable = measurables.first { it.layoutId == "text" }.measure(constraints)

        placeTextAndIcon(
            textPlaceable,
            iconPlaceable,
            constraints.maxWidth,
            constraints.maxHeight,
            animationProgress
        )
    }
}

private fun MeasureScope.placeTextAndIcon(
    textPlaceable: Placeable,
    iconPlaceable: Placeable,
    width: Int,
    height: Int,
    @FloatRange(from = 0.0, to = 1.0) animationProgress: Float
): MeasureResult {
    val iconY = (height - iconPlaceable.height) / 2
    val textY = (height - textPlaceable.height) / 2

    val textWidth = textPlaceable.width * animationProgress
    val iconX = (width - textWidth - iconPlaceable.width) / 2
    val textX = iconX + iconPlaceable.width

    return layout(width, height) {
        iconPlaceable.placeRelative(iconX.toInt(), iconY)
        if (animationProgress != 0f) {
            textPlaceable.placeRelative(textX.toInt(), textY)
        }
    }
}

@Composable
private fun BottomNavigationLayout(
    selectedIndex: Int,
    itemCount: Int,
    animSpec: AnimationSpec<Float>,
    indicator: @Composable BoxScope.() -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    // Track how "selected" each item is [0, 1]
    val selectionFractions = remember(itemCount) {
        List(itemCount) { i ->
            Animatable(if (i == selectedIndex) 1f else 0f)
        }
    }
    selectionFractions.forEachIndexed { index, selectionFraction ->
        val target = if (index == selectedIndex) 1f else 0f
        LaunchedEffect(target, animSpec) {
            selectionFraction.animateTo(target, animSpec)
        }
    }

    // Animate the position of the indicator
    val indicatorIndex = remember { Animatable(0f) }
    val targetIndicatorIndex = selectedIndex.toFloat()
    LaunchedEffect(targetIndicatorIndex) {
        indicatorIndex.animateTo(targetIndicatorIndex, animSpec)
    }

    Layout(
        modifier = modifier.height(BottomNavHeight),
        content = {
            content()
            Box(Modifier.layoutId("indicator"), content = indicator)
        }
    ) { measurables, constraints ->
        check(itemCount == (measurables.size - 1)) // account for indicator

        // Divide the width into n+1 slots and give the selected item 2 slots
        val unselectedWidth = constraints.maxWidth / (itemCount + 1)
        val selectedWidth = 2 * unselectedWidth
        val indicatorMeasurable = measurables.first { it.layoutId == "indicator" }

        val itemPlaceables = measurables
            .filterNot { it == indicatorMeasurable }
            .mapIndexed { index, measurable ->
                // Animate item's width based upon the selection amount
                val width = lerp(
                    ScaleFactor(unselectedWidth.toFloat(), 0f),
                    ScaleFactor(0f, selectedWidth.toFloat()),
                    selectionFractions[index].value
                )
                measurable.measure(
                    constraints.copy(
                        minWidth = width.scaleX.toInt(),
                        maxWidth = width.scaleY.toInt()
                    )
                )
            }
        val indicatorPlaceable = indicatorMeasurable.measure(
            constraints.copy(
                minWidth = selectedWidth,
                maxWidth = selectedWidth
            )
        )

        layout(
            width = constraints.maxWidth,
            height = itemPlaceables.maxByOrNull { it.height }?.height ?: 0
        ) {
            val indicatorLeft = indicatorIndex.value * unselectedWidth
            indicatorPlaceable.placeRelative(x = indicatorLeft.toInt(), y = 0)
            var x = 0
            itemPlaceables.forEach { placeable ->
                placeable.placeRelative(x = x, y = 0)
                x += placeable.width
            }
        }
    }
}

@Composable
private fun BottomNavigationIndicator(
    strokeWidth: Dp = 2.dp,
    color: Color = HealthAppTheme.colors.iconInteractive,
    shape: Shape = BottomNavIndicatorShape
) {
    Spacer(
        modifier = Modifier
            .fillMaxSize()
            .then(BottomNavigationItemPadding)
            .border(strokeWidth, color, shape)
    )
}

enum class MainSections(
    @StringRes val title: Int,
    val icon: ImageVector,
    val route: String
) {
    DASHBOARD(
        R.string.bottom_menu_home,
        Icons.Outlined.Home,
        Destinations.DASHBOARD_ROUTE
    ),
    STATISTICS(
        R.string.bottom_menu_statistics,
        Icons.Outlined.Search,
        Destinations.STATISTICS_ROUTE
    ),
    SETTINGS(
        R.string.bottom_menu_settings,
        Icons.Outlined.ShoppingCart,
        Destinations.SETTINGS_ROUTE
    ),
    PROFILE(
        R.string.bottom_menu_profile,
        Icons.Outlined.AccountCircle,
        Destinations.PROFILE_ROUTE
    )
}

private val TextIconSpacing = 2.dp
private val BottomNavHeight = 56.dp
private val BottomNavLabelTransformOrigin = TransformOrigin(0f, 0.5f)
private val BottomNavIndicatorShape = RoundedCornerShape(percent = 50)
private val BottomNavigationItemPadding = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
