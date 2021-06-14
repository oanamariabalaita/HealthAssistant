package com.example.healthassistant.presentation.features.dashboard

import android.content.Context
import android.widget.Toast
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.healthassistant.R
import com.example.healthassistant.data.model.HealthIndexEntity
import com.example.healthassistant.domain.model.HealthIndex
import com.example.healthassistant.domain.model.HealthSummary
import com.example.healthassistant.domain.utils.extensions.toModel
import kotlinx.coroutines.flow.onEach
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.koin.androidx.compose.getViewModel
import java.io.InputStream
import java.util.Scanner

@Composable
fun Dashboard(
    applicationContext: Context,
    navigateToSettings: () -> Unit,
    navigateToStatistics: () -> Unit,
    navigateToHealthCardDetails: () -> Unit,
    navigateToHealthSummaryDetails: () -> Unit,
    dashboardViewModel: DashboardViewModel = getViewModel()
) {
    when (dashboardViewModel.healthIndicesViewState.collectAsState().value) {
        is HealthIndicesViewState.Success -> {
            val string = applicationContext.resources
                .openRawResource(R.raw.health_index)
            val index = Json.decodeFromString<HealthIndexEntity>(
                """${convertStreamToString(string)}"""
            )
            HealthIndicesList(listOf(index.toModel))
        }
        is HealthIndicesViewState.Error -> {
            val string = stringResource(R.raw.health_index)
            val index = Json.decodeFromString<HealthIndexEntity>(
                string
            )
            HealthIndicesList(listOf(index.toModel))
        }
    }
    dashboardViewModel.effectFlow.onEach {
        when (it) {
            is DashboardEffect.ShowToast -> {
                Toast.makeText(
                    applicationContext,
                    "Toast: is working ok",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}

fun convertStreamToString(x: InputStream?): String? {
    val s = Scanner(x).useDelimiter("\\A")
    return if (s.hasNext()) s.next() else ""
}

@Composable
fun HealthIndicesList(indices: List<HealthIndex>) {
    LazyColumn {
        items(indices) { index ->
            HealthIndexCard(index)
        }
    }
}

@Composable
fun HealthIndexCard(index: HealthIndex) {

}

@Composable
fun HealthSummaryCard(
    summary: HealthSummary,
    onSummaryChange: (HealthSummary) -> Unit,
    onSummaryClick: () -> Unit
) {
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

private fun handleIndicesViewState(state: HealthIndicesViewState) {
    when (state) {
        is HealthIndicesViewState.Success -> {
        }
        is HealthIndicesViewState.Error -> {
        }
    }
}

private fun handleUserViewState(state: UserViewState) {
    when (state) {
        is UserViewState.Success -> {
        }
        is UserViewState.Error -> {
        }
        is UserViewState.Empty -> {
        }
    }
}

@Composable
fun NotificationsButton() {
}

@Composable
fun MenuFloatingButton() {

}

@Composable
fun HealthSummaryCard() {
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
            .padding(top = paddingWithStatusBarHeight, bottom = 8.dp, start = 8.dp, end = 8.dp)
    ) {
        val (title, image, price, asset, dailyChange, send, receive, scan) = createRefs()
        val horizontalCenterGuideline = createGuidelineFromStart(0.5f)
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
