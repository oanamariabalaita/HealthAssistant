package com.example.healthassistant.presentation.main

import android.content.Context
import android.net.ConnectivityManager
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.rememberNavController
import com.example.healthassistant.R
import com.example.healthassistant.presentation.components.MyAlertDialog
import com.example.healthassistant.presentation.components.Scaffold
import com.example.healthassistant.presentation.router.HealthAssistantRouter

@Composable
fun MainView() {

    val navController = rememberNavController()
    val context = LocalContext.current
    var isOnline by remember { mutableStateOf(checkIfOnline(context)) }

    if (isOnline) {
        Scaffold(
        ) { innerPaddingModifier ->
            HealthAssistantRouter(
                navController = navController,
                modifier = Modifier.padding(innerPaddingModifier)
            )
        }
    } else {
        MyAlertDialog(
            title = { Text(text = stringResource(R.string.connection_error_title)) },
            text = { Text(text = stringResource(R.string.connection_error_message)) },
            confirmButton = { isOnline = checkIfOnline(context) },
            confirmButtonText = stringResource(R.string.retry_label)
        )
    }
}

@Suppress("DEPRECATION")
private fun checkIfOnline(context: Context): Boolean {
    val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork = cm.activeNetworkInfo
    return activeNetwork?.isConnectedOrConnecting == true
}
