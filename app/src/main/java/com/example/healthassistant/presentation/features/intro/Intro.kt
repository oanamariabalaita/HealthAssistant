package com.example.healthassistant.presentation.features.intro

import android.content.Context
import android.os.Build
import android.util.DisplayMetrics
import android.view.View
import android.widget.Button
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Explore
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.example.healthassistant.R
import com.example.healthassistant.databinding.IntroFragmentBinding
import com.example.healthassistant.presentation.theme.HealthAppTheme

@Composable
fun Intro(
    introComplete: () -> Unit,
    navigateToDashboard: () -> Unit
) {
    HealthAppTheme {
        Scaffold(
            backgroundColor = MaterialTheme.colors.primarySurface,
            floatingActionButton = {
                FloatingActionButton(onClick = navigateToDashboard) {
                    Icon(
                        imageVector = Icons.Rounded.Explore,
                        contentDescription = stringResource(R.string.bottom_menu_profile)
                    )
                }
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier.padding(innerPadding)
            ) {
                Text(
                    text = stringResource(R.string.email),
                    style = MaterialTheme.typography.h4,
                    textAlign = TextAlign.End,
                    modifier = Modifier.padding(
                        horizontal = 16.dp,
                        vertical = 32.dp
                    )
                )
                Spacer(Modifier.height(56.dp))
            }
        }
    }
}

@Preview(name = "Intro")
@Composable
private fun IntroPreview() {
    Intro(introComplete = { }, navigateToDashboard = { })
}

private const val CIRCULAR_FRAMES_COUNT = 3
private lateinit var viewBinding: IntroFragmentBinding
private val indicators = mutableListOf<View>()
private var currentPosition = 0

//private fun attachNextButtonListener() {
//    viewBinding.next.setOnClickListener {
//        when (currentPosition) {
//            0 -> viewBinding.next.navigate(R.id.firstTransition, R.id.secondTransition)
//            1 -> viewBinding.next.navigate(R.id.secondTransition, R.id.thirdTransition)
//            else -> dismiss()
//        }
//    }
//}

private fun attachPreviousButtonListener() {
    viewBinding.previous.setOnClickListener {
        when (currentPosition) {
            2 -> viewBinding.previous.navigate(R.id.thirdTransition, R.id.secondTransition)
            else -> viewBinding.previous.navigate(R.id.secondTransition, R.id.firstTransition)
        }
    }
}

private fun updateNavState() {
    when {
        currentPosition > 0 -> viewBinding.previous.visibility = View.VISIBLE
        else -> viewBinding.previous.visibility = View.INVISIBLE
    }
}

private fun Button.navigate(startId: Int, endId: Int) {
    currentPosition = when (id) {
        R.id.next -> currentPosition.inc()
        else -> currentPosition.dec()
    }
    updateNavState()

    if (endId == R.id.thirdTransition) {
        viewBinding.navContainer.setBackgroundColor(
            ContextCompat.getColor(
                context,
                R.color.color_intro_page3
            )
        )
        viewBinding.next.text = context.getString(R.string.next_step)
    } else {
        viewBinding.next.text = context.getString(R.string.complete_step)
        viewBinding.navContainer.setBackgroundColor(
            ContextCompat.getColor(
                context, R.color.intro_background
            )
        )
    }
    viewBinding.motionContainer.motionLayout.setTransition(startId, endId)
    viewBinding.motionContainer.motionLayout.transitionToEnd()
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        updateIndicators()
    }
}

private fun updateIndicators() {
    indicators.forEachIndexed { index, view ->
        val backgroundRes = when (index) {
            currentPosition -> R.drawable.intro_selected_dot
            else -> R.drawable.intro_unselected_dot
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            view.setBackgroundResource(backgroundRes)
        }
    }
}
//
//private fun setIndicators() {
//    val dotRadius: Int = convertDpToPixel(12f, context)
//    val margin: Int = convertDpToPixel(4f, context)
//    indicators.clear()
//    viewBinding.indicatorsContainer.removeAllViews()
//    for (i in 0 until CIRCULAR_FRAMES_COUNT) {
//        val view = View(context)
//        view.id = View.generateViewId()
//        val layoutParams = FrameLayout.LayoutParams(dotRadius * 2, dotRadius * 2)
//        layoutParams.setMargins(margin, margin, margin, margin)
//        view.layoutParams = layoutParams
//        indicators.add(view)
//        viewBinding.indicatorsContainer.addView(view)
//    }
//}

private fun convertDpToPixel(dp: Float, context: Context?): Int {
    if (context != null) {
        val px =
            (dp * (context.resources.displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT))
        return px.toInt()
    }
    return 0
}
