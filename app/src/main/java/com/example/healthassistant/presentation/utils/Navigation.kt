package com.example.healthassistant.presentation.utils

import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.staticCompositionLocalOf

@Composable
fun backHandler(
    enabled: Boolean = true,
    onBack: () -> Unit
) {
    // Safely update the current `onBack` lambda when a new one is provided
    val currentOnBack by rememberUpdatedState(onBack)
    // Remember in Composition a back callback that calls the `onBack` lambda
    val backCallback = remember {
        object : OnBackPressedCallback(enabled) {
            override fun handleOnBackPressed() {
                currentOnBack()
            }
        }
    }
    // On every successful composition, update the callback with the `enabled` value
    SideEffect {
        backCallback.isEnabled = enabled
    }
    val backDispatcher = LocalBackDispatcher.current
    // If `backDispatcher` changes, dispose and reset the effect
    DisposableEffect(backDispatcher) {
        // Add callback to the backDispatcher
        backDispatcher.addCallback(backCallback)
        // When the effect leaves the Composition, remove the callback
        onDispose {
            backCallback.remove()
        }
    }
}

/**
 * An [androidx.compose.runtime.Ambient] providing the current [OnBackPressedDispatcher]. You must
 * [provide][androidx.compose.runtime.Providers] a value before use.
 */
internal val LocalBackDispatcher = staticCompositionLocalOf<OnBackPressedDispatcher> {
    error("No Back Dispatcher provided")
}
