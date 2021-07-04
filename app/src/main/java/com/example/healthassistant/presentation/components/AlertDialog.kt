package com.example.healthassistant.presentation.components

import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import com.example.healthassistant.presentation.theme.HealthAppTheme

@Composable
fun MyAlertDialog(
    onDismissRequest: () -> Unit = {},
    confirmButton: () -> Unit,
    confirmButtonText: String,
    modifier: Modifier = Modifier,
    dismissButton: @Composable (() -> Unit)? = null,
    title: @Composable (() -> Unit)? = null,
    text: @Composable (() -> Unit)? = null,
    shape: Shape = MaterialTheme.shapes.small,
    backgroundColor: Color = HealthAppTheme.colors.baseColors.background,
    contentColor: Color = HealthAppTheme.colors.baseColors.surface
) {
    AlertDialog(
        onDismissRequest = onDismissRequest,
        title = text,
        text = title,
        confirmButton = {
            Button(onClick = confirmButton) {
                Text(text = confirmButtonText)
            }
        }
    )
}
