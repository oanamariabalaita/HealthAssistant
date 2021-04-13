package com.example.healthassistant.presentation.components

import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import com.example.healthassistant.R

@Composable
fun MyAlertDialog(
    onDismissRequest: () -> Unit,
    confirmButton: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    dismissButton: @Composable (() -> Unit)? = null,
    title: @Composable (() -> Unit)? = null,
    text: @Composable (() -> Unit)? = null,
    shape: Shape = MaterialTheme.shapes.medium,
    backgroundColor: Color = MaterialTheme.colors.surface,
    contentColor: Color = contentColorFor(backgroundColor)
) {
    val shouldShowDialog = remember { mutableStateOf(true) } // 1

    if (shouldShowDialog.value) {
        AlertDialog(
            onDismissRequest = { shouldShowDialog.value = false },
            title = { Text(text = stringResource(id = R.string.a_minute_ago)) },
            text = { Text(text = stringResource(id = R.string.an_hour_ago_abbreviate)) },
            confirmButton = { // 6
                Button(
                    colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.colorPrimary)),
                    onClick = { shouldShowDialog.value = false }
                ) {
                    Text(
                        text = stringResource(id = R.string.email),
                        color = Color.White
                    )
                }
            }
        )
    }
}
