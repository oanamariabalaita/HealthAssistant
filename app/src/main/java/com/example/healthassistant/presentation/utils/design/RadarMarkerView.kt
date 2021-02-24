package com.example.healthassistant.presentation.utils.design

import android.content.Context
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import com.example.healthassistant.R
import com.example.healthassistant.databinding.RadarMarkerviewBinding
import com.github.mikephil.charting.components.MarkerView
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.utils.MPPointF

class RadarMarkerView(context: Context, layoutResource: Int) : MarkerView(context, layoutResource) {

    private lateinit var viewBinding: RadarMarkerviewBinding

    init {
        val viewBinding = RadarMarkerviewBinding
            .inflate(LayoutInflater.from(context))
        View.inflate(context, R.layout.intro_layout_bubble_item, viewBinding.root)

        viewBinding.tvContent.typeface =
            Typeface.createFromAsset(context.assets, "OpenSans-Light.ttf")
    }

    override fun refreshContent(e: Entry, highlight: Highlight) {
        viewBinding.tvContent.text = (e.y).toInt().toString()
        super.refreshContent(e, highlight)
    }

    override fun getOffset(): MPPointF {
        return MPPointF((-(width / 2)).toFloat(), (-height - 10).toFloat())
    }
}
