package com.example.healthassistant.presentation.features.intro

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import com.example.healthassistant.R

class IntroBubbleView @kotlin.jvm.JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    init {
        val ta = context.obtainStyledAttributes(attrs, R.styleable.IntroBubbleView)
        val text = ta.getString(R.styleable.IntroBubbleView_bl_text) ?: ""
        val textGravity = ta.getInt(R.styleable.IntroBubbleView_bl_alignment, 0)
        val textDescription = ta.getString(R.styleable.IntroBubbleView_bl_description) ?: ""

        val composeView = ComposeView(context).apply {
            setContent {
                MaterialTheme {
                    Text(
                        text,
                        modifier = Modifier.padding(30.dp),
                    )
                }
            }
        }
        addView(composeView)
        ta.recycle()
    }
}
