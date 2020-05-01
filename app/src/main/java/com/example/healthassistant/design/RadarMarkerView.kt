package com.example.healthassistant.design

import android.content.Context
import android.graphics.Typeface
import com.github.mikephil.charting.components.MarkerView
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.utils.MPPointF
import kotlinx.android.synthetic.main.radar_markerview.view.tvContent

class RadarMarkerView(context: Context, layoutResource: Int) : MarkerView(context, layoutResource) {

    init {
        tvContent.typeface = Typeface.createFromAsset(context.assets, "OpenSans-Light.ttf")
    }

    override fun refreshContent(e: Entry, highlight: Highlight) {

        tvContent.text = (e.y).toInt().toString()
        super.refreshContent(e, highlight)
    }

    override fun getOffset(): MPPointF {
        return MPPointF((-(width / 2)).toFloat(), (-height - 10).toFloat())
    }
}
