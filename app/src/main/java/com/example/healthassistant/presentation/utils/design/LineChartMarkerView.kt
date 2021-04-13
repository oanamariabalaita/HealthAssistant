package com.example.healthassistant.presentation.utils.design

import android.content.Context
import com.github.mikephil.charting.components.MarkerView
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.utils.MPPointF

class LineChartMarkerView(context: Context, layoutResource: Int) :
    MarkerView(context, layoutResource) {

  //  private lateinit var viewBinding: CustomMarkerViewBinding

    init {
//        val viewBinding = CustomMarkerViewBinding
//            .inflate(LayoutInflater.from(context))
//        View.inflate(context, R.layout.intro_layout_bubble_item, viewBinding.root)
//        viewBinding.tvContentLine.typeface =
//            Typeface.createFromAsset(context.assets, "OpenSans-Light.ttf")
    }

    override fun refreshContent(entry: Entry, highlight: Highlight) {
//        if (entry is CandleEntry) {
//            viewBinding.tvContentLine.text = Utils.formatNumber(entry.high, 0, true)
//        } else {
//            viewBinding.tvContentLine.text = Utils.formatNumber(entry.y, 0, true)
//        }
//        super.refreshContent(entry, highlight)
    }

    override fun getOffset(): MPPointF {
        return MPPointF((-(width / 2)).toFloat(), (-height).toFloat())
    }
}
