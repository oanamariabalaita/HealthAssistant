package com.example.healthassistant.presentation.features.dashboard

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.healthassistant.R
import kotlinx.coroutines.flow.onEach

@Composable
fun Dashboard(applicationContext: Context, dashboardViewModel: DashboardViewModel) {

    LaunchedEffect(key1 = "", block = {})

    dashboardViewModel.apply {
        when (userViewState.collectAsState().value) {

        }
        effectFlow.onEach {
            when (it) {
                is DashboardEffect.ShowToast -> {
                    Toast.makeText(applicationContext, "Toast: is working ok", Toast.LENGTH_SHORT)
                        .show()

                }
            }
        }
    }
}

@Preview
@Composable
fun HealthSummary() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Surface(
            modifier = Modifier.size(50.dp),
            shape = CircleShape,
            color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
        ) {
            Image(painterResource(R.drawable.app_logo_round), contentDescription = "Test")
        }
        Column(
            modifier = Modifier
                .padding(start = 8.dp)
                .align(Alignment.CenterVertically)
        ) {
            Text("name", fontWeight = FontWeight.Bold)
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Text("12.02.2021", style = MaterialTheme.typography.body2)
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
fun Card(
    modifier: Modifier = Modifier,
    shape: Shape = MaterialTheme.shapes.medium,
    backgroundColor: Color = MaterialTheme.colors.surface,
    contentColor: Color = contentColorFor(backgroundColor),
    border: BorderStroke? = null,
    elevation: Dp = 1.dp,
    content: @Composable () -> Unit
) {

}



