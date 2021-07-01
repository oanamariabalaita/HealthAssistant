package com.example.healthassistant.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.healthassistant.R

@Composable
fun ComingSoon() {
    val animationSpec = rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(R.raw.app_comming_soon)
    )
    LottieAnimation(
        composition = animationSpec.value,
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
    )
}
