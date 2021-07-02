package com.example.healthassistant.presentation.features.dashboard

import android.content.Context
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ContentAlpha
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.FloatingActionButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.healthassistant.R
import com.example.healthassistant.data.model.HealthIndexEntity
import com.example.healthassistant.domain.model.HealthIndex
import com.example.healthassistant.domain.model.HealthSummary
import com.example.healthassistant.domain.utils.extensions.toModel
import com.example.healthassistant.presentation.components.DividerComponent
import com.example.healthassistant.presentation.components.DraggableCard
import com.example.healthassistant.presentation.components.Loader
import com.example.healthassistant.presentation.theme.HealthAppTheme
import com.example.healthassistant.presentation.theme.blue3
import com.example.healthassistant.presentation.utils.extensions.verticalGradientBackground
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.koin.androidx.compose.getViewModel
import java.io.InputStream
import java.util.Scanner

@Composable
fun Dashboard(
    modifier: Modifier,
    applicationContext: Context,
    navigateToHealthCardDetails: () -> Unit,
    navigateToHealthSummaryDetails: () -> Unit,
    dashboardViewModel: DashboardViewModel = getViewModel()
) {
    val string = applicationContext.resources
        .openRawResource(R.raw.indices_mock)
    val index = Json.decodeFromString<List<HealthIndexEntity>>(
        """${convertStreamToString(string)}"""
    )
    val mock = index.map { it.toModel }
    val state = dashboardViewModel.state.collectAsState().value

    LaunchedEffect(key1 = "DASHBOARD_EFFECT", block = {
        launch {
            dashboardViewModel.effect.collect {
                handleEffects(it)
            }
        }
    })
    DashboardContent(modifier = modifier, state, mock)
}

@Composable
private fun DashboardContent(
    modifier: Modifier,
    state: DashboardState,
    mock: List<HealthIndex>
) {
    Box(
        modifier = modifier
            .background(
                color = HealthAppTheme.colors.baseColors.background,
                shape = RectangleShape
            )
    ) {
        DividerComponent()
        Column {
            IndicesListContent(
                state = state,
                mock = mock
            )
        }
    }
}

@Composable
private fun IndicesListContent(
    state: DashboardState,
    mock: List<HealthIndex>
) {
    Surface(modifier = Modifier.fillMaxHeight()) {
        Box(
            modifier = Modifier.verticalGradientBackground(
                listOf(
                    Color.White,
                    blue3.copy(alpha = 0.2f)
                )
            )
        ) {
            if (state.healthIndicesLoading) Loader()
            else HealthIndicesList(mock)
        }
    }
}

fun convertStreamToString(x: InputStream?): String
? {
    val s = Scanner(x).useDelimiter("\\A")
    return if (s.hasNext()) s.next() else ""
}

@Composable
fun HealthIndicesList(indices: List<HealthIndex>) {

    LazyColumn {
        items(indices) { healthIndex ->
            DraggableCard(
                item = healthIndex,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .padding(
                        top = 16.dp,
                        bottom = 16.dp,
                        start = 16.dp,
                        end = 16.dp
                    ),
                { _, _ -> }
            ) {
                HealthIndexCard(healthIndex)
            }
        }
    }
}

@Composable
fun HealthIndexCard(index: HealthIndex) {
    Card(
        Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(20.dp), elevation = 8.dp
    ) {
        Text(index.descriptiveVal + ": " + index.quantitativeVal)
    }
}

@Composable
fun HealthSummaryCard(
    summary: HealthSummary,
    onSummaryChange: (HealthSummary) -> Unit,
    onSummaryClick: () -> Unit
) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val summaryCardHeight = screenHeight - 200.dp

    Row(verticalAlignment = Alignment.CenterVertically) {
        Surface(
            modifier = Modifier
                .size(50.dp)
                .clickable { onSummaryClick.invoke() },
            shape = CircleShape,
            color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
        ) {
        }
        Column(
            modifier = Modifier
                .padding(start = 8.dp)
                .align(Alignment.CenterVertically)
        ) {
            Text("name", fontWeight = FontWeight.Bold)
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Text("12.02.2021", style = typography.body2)
            }
        }
    }
}

@Composable
fun HealthSummaryCard(summary: HealthSummary) {
    val paddingWithStatusBarHeight = 40.dp
    var extended by remember { mutableStateOf(false) }
    val animateHeight = if (extended) 500.dp else 200.dp
    val opacity = if (extended) 0.8f else 1f

    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .height(animateDpAsState(animateHeight).value)
            .alpha(animateFloatAsState(opacity).value)
            .clip(RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp))
            .padding(
                top = paddingWithStatusBarHeight,
                bottom = 8.dp,
                start = 8.dp,
                end = 8.dp
            )
    ) {
        val (title, image, price, asset, dailyChange, send, receive, scan) = createRefs()
        val horizontalCenterGuideline = createGuidelineFromStart(0.5f)

        Column() {
        }

        Text(
            text = "Health Report",
            style = typography.body1,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(4.dp)
                .constrainAs(title) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
        ExtendedFloatingActionButton(
            onClick = { extended = !extended },
            modifier = Modifier
                .padding(4.dp)
                .border(1.dp, Color.White, RoundedCornerShape(5.dp))
                .constrainAs(send) {
                    start.linkTo(horizontalCenterGuideline)
                    end.linkTo(parent.end)
                    top.linkTo(asset.bottom)
                },
            icon = { Icon(imageVector = Icons.Default.Send, contentDescription = null) },
            text = { Text(text = "See more") },
            backgroundColor = Color.Transparent,
            elevation = FloatingActionButtonDefaults.elevation()
        )
        Image(
            imageVector = Icons.Default.ExpandMore,
            contentDescription = null,
            modifier = Modifier
                .size(250.dp)
                .alpha(animateFloatAsState(if (extended) 1f else 0f).value)
                .constrainAs(scan) {
                    top.linkTo(receive.bottom, margin = 50.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
    }
}

fun handleEffects(effect: DashboardEffect) {
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
