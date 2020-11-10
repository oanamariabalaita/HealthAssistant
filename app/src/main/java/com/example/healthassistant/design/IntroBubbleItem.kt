package com.example.healthassistant.design

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import com.example.healthassistant.R
import com.example.healthassistant.databinding.IntroLayoutBubbleItemBinding

class IntroBubbleItem @kotlin.jvm.JvmOverloads
constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private lateinit var viewBinding: IntroLayoutBubbleItemBinding

    init {
        initView(attrs)
    }

    private fun initView(attrs: AttributeSet?) {
        val ta = context.obtainStyledAttributes(attrs, R.styleable.IntroBubbleItem)
        val textColor = ta.getColor(R.styleable.IntroBubbleItem_bl_text_color, Color.BLACK)
        val gravity = ta.getInt(R.styleable.IntroBubbleItem_bl_alignment, 0)
        val text = ta.getString(R.styleable.IntroBubbleItem_bl_text)
        val description = ta.getString(R.styleable.IntroBubbleItem_bl_description)
        val viewBinding = IntroLayoutBubbleItemBinding
            .inflate(LayoutInflater.from(context))

        View.inflate(context, R.layout.intro_layout_bubble_item, this.viewBinding.root)

        viewBinding.apply {
            bubbleItemTitle.text = text
            bubbleItemTitle.setTextColor(textColor)
            bubbleItemTitle.gravity = gravity
            bubbleItemDescription.text = description
            bubbleItemDescription.setTextColor(textColor)
            bubbleItemDescription.gravity = gravity
            ta.recycle()
        }
    }
}
