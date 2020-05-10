package com.example.healthassistant.design

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import com.example.healthassistant.R
import kotlinx.android.synthetic.main.intro_layout_bubble_item.view.bubbleItemDescription
import kotlinx.android.synthetic.main.intro_layout_bubble_item.view.bubbleItemTitle

class IntroBubbleItem @kotlin.jvm.JvmOverloads
constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    FrameLayout(context, attrs, defStyleAttr) {

    init {
        initView(attrs)
    }

    private fun initView(attrs: AttributeSet?) {
        View.inflate(context, R.layout.intro_layout_bubble_item, this)
        val ta = context.obtainStyledAttributes(attrs, R.styleable.IntroBubbleItem)

        val textColor = ta.getColor(R.styleable.IntroBubbleItem_bl_text_color, Color.BLACK)
        val gravity = ta.getInt(R.styleable.IntroBubbleItem_bl_alignment, 0)

        val text = ta.getString(R.styleable.IntroBubbleItem_bl_text)
        bubbleItemTitle.text = text
        bubbleItemTitle.setTextColor(textColor)
        bubbleItemTitle.setTextGravity(gravity)

        val description = ta.getString(R.styleable.IntroBubbleItem_bl_description)
        bubbleItemDescription.text = description
        bubbleItemDescription.setTextColor(textColor)
        bubbleItemDescription.setTextGravity(gravity)
        ta.recycle()
    }

    private fun TextView.setTextGravity(value: Int) {}

    private fun ImageView.setGravity(value: Int) {}

    private fun showDetail(visibility: Int) {}
}
