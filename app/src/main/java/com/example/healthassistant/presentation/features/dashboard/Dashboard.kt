package com.example.healthassistant.presentation.features.dashboard

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FractionalThreshold
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.rememberSwipeableState
import androidx.compose.material.swipeable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.healthassistant.domain.model.HealthIndex
import com.example.healthassistant.presentation.components.DraggableCard
import com.example.healthassistant.presentation.components.Loader
import com.example.healthassistant.presentation.components.MenuSheet
import com.example.healthassistant.presentation.components.SheetState
import com.example.healthassistant.presentation.theme.GreenDarkPrimary
import com.example.healthassistant.presentation.utils.ui.NetworkImage
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Dashboard(
    modifier: Modifier,
    navigateToHealthCardDetails: () -> Unit,
    navigateToNotifications: () -> Unit,
    navigateToStatistics: () -> Unit,
    navigateToSettings: () -> Unit,
    navigateToProfile: () -> Unit,
    dashboardViewModel: DashboardViewModel = getViewModel()
) {

    val state = dashboardViewModel.state.collectAsState().value

    LaunchedEffect(key1 = "DASHBOARD_EFFECT", block = {
        launch {
            dashboardViewModel.effect.collect {
                handleEffects(it)
            }
        }
    })
    BoxWithConstraints {
        val sheetState = rememberSwipeableState(SheetState.Closed)
        val fabSize = with(LocalDensity.current) { FabSize.toPx() }
        val dragRange = constraints.maxHeight - fabSize
        val scope = rememberCoroutineScope()

        BackHandler(
            enabled = sheetState.currentValue == SheetState.Open,
            onBack = {
                scope.launch {
                    sheetState.animateTo(SheetState.Closed)
                }
            }
        )
        Box(
            modifier.swipeable(
                state = sheetState,
                anchors = mapOf(
                    0f to SheetState.Closed,
                    -dragRange to SheetState.Open
                ),
                thresholds = { _, _ -> FractionalThreshold(0.5f) },
                orientation = Orientation.Vertical
            )
        ) {
            val openFraction = if (sheetState.offset.value.isNaN()) {
                0f
            } else {
                -sheetState.offset.value / dragRange
            }.coerceIn(0f, 1f)

            HealthSummaryCard(state.healthSummaryScore, state.summaryLoading)

            IndicesListContent(state)

            MenuSheet(
                { MenuContent() },
                openFraction,
                this@BoxWithConstraints.constraints.maxWidth.toFloat(),
                this@BoxWithConstraints.constraints.maxHeight.toFloat()
            ) { state ->
                scope.launch {
                    sheetState.animateTo(state)
                }
            }
        }
    }
}

@Composable
private fun MenuContent() {
    Text(text = "WORKINGGG")
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun IndicesListContent(state: DashboardState) {
    Surface(modifier = Modifier.fillMaxHeight()) {
        Box(
            modifier = Modifier.verticalGradientBackground(
                listOf(
                    Color.White,
                    GreenDarkPrimary.copy(alpha = 0.2f)
                )
            )
        ) {
            if (state.healthIndicesLoading) Loader()
            else HealthIndicesList(state.indices)
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HealthIndicesList(indices: List<HealthIndex>) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val cardWidth = (screenWidth / 2) - 16.dp

    LazyVerticalGrid(cells = GridCells.Fixed(2)) {
        itemsIndexed(indices) { row, item ->
            DraggableCard(
                item = item,
                modifier = Modifier
                    .width(cardWidth)
                    .padding(4.dp),
                { _, _ -> }
            ) {
                HealthIndexCard(item)
            }
        }
    }
}

@Composable
fun HealthIndexCard(index: HealthIndex) {
    Text(index.descriptiveVal + ": " + index.quantitativeVal)
}

@Composable
fun HealthSummaryCard(
    healthIndex: Float,
    healthSummaryLoading: Boolean
) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val summaryCardHeight = screenHeight / 4

    Surface(
        elevation = 16.dp,
        shape = RectangleShape,
        modifier = Modifier
            .padding(end = 8.dp)
            .fillMaxWidth()
            .height(summaryCardHeight),
    ) {
        Row {
            NetworkImage(
                url = "https://play-lh.googleusercontent.com/Ui7iNIIJKajTlE1fJzFjNTHrilzBDcUROWSL7kn2IcdnrdQyTCroHjXRWkE7K5d_M",
                contentDescription = null,
                modifier = Modifier
                    .size(28.dp)
                    .clip(CircleShape)
            )
            Column(modifier = Modifier.padding(16.dp)) {
                if (!healthSummaryLoading) {
                    Text(
                        text = healthIndex.toString(),
                        style = MaterialTheme.typography.subtitle1,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier
                            .weight(1f)
                            .padding(bottom = 4.dp)
                    )
                }
            }
        }
    }
}

private fun handleEffects(effect: DashboardEffect) {
    when (effect) {
        DashboardEffect.LoadHealthIndicesError -> {
        }
        DashboardEffect.LoadHealthSummaryError -> {
        }
        DashboardEffect.LoadUserError -> {
        }
        is DashboardEffect.ShowToast -> {
        }
    }
}
