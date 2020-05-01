package com.example.healthassistant.design

import android.content.Context
import android.graphics.Typeface
import com.github.mikephil.charting.components.MarkerView
import com.github.mikephil.charting.data.CandleEntry
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.utils.MPPointF
import com.github.mikephil.charting.utils.Utils
import kotlinx.android.synthetic.main.custom_marker_view.view.tvContentLine

class LineChartMarkerView(context: Context, layoutResource: Int) :
    MarkerView(context, layoutResource) {

    init {
        tvContentLine.typeface = Typeface.createFromAsset(context.assets, "OpenSans-Light.ttf")
    }

    override fun refreshContent(e: Entry, highlight: Highlight) {

        if (e is CandleEntry) {

            val ce = e

            tvContentLine.text = Utils.formatNumber(ce.high, 0, true)
        } else {

            tvContentLine.text = Utils.formatNumber(e.y, 0, true)
        }

        super.refreshContent(e, highlight)
    }

    override fun getOffset(): MPPointF {
        return MPPointF((-(width / 2)).toFloat(), (-height).toFloat())
    }
}
