package com.example.healthassistant.design

import android.content.Context
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import com.example.healthassistant.R
import com.example.healthassistant.databinding.CustomMarkerViewBinding
import com.github.mikephil.charting.components.MarkerView
import com.github.mikephil.charting.data.CandleEntry
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.utils.MPPointF
import com.github.mikephil.charting.utils.Utils

class LineChartMarkerView(context: Context, layoutResource: Int) :
    MarkerView(context, layoutResource) {

    private lateinit var viewBinding: CustomMarkerViewBinding

    init {
        val viewBinding = CustomMarkerViewBinding
            .inflate(LayoutInflater.from(context))
        View.inflate(context, R.layout.intro_layout_bubble_item, viewBinding.root)
        viewBinding.tvContentLine.typeface =
            Typeface.createFromAsset(context.assets, "OpenSans-Light.ttf")
    }

    override fun refreshContent(e: Entry, highlight: Highlight) {
        if (e is CandleEntry) {
            viewBinding.tvContentLine.text = Utils.formatNumber(e.high, 0, true)
        } else {
            viewBinding.tvContentLine.text = Utils.formatNumber(e.y, 0, true)
        }
        super.refreshContent(e, highlight)
    }

    override fun getOffset(): MPPointF {
        return MPPointF((-(width / 2)).toFloat(), (-height).toFloat())
    }
}
