package com.example.healthassistant.ui.intro

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import androidx.fragment.app.DialogFragment
import com.example.healthassistant.R
import com.example.healthassistant.databinding.IntroFragmentBinding

class IntroFragment : DialogFragment() {

    private lateinit var viewBinding: IntroFragmentBinding
    private val indicators = mutableListOf<View>()
    private var currentPosition = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = IntroFragmentBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setIndicators()
        updateIndicators()
        attachNextButtonListener()
        attachPreviousButtonListener()
    }

    private fun attachNextButtonListener() {
        viewBinding.next.setOnClickListener {
            when (currentPosition) {
                0 -> viewBinding.next.navigate(R.id.firstTransition, R.id.secondTransition)
                1 -> viewBinding.next.navigate(R.id.secondTransition, R.id.thirdTransition)
                else -> dismiss()
            }
        }
    }

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
            viewBinding.navContainer.setBackgroundColor(resources.getColor(R.color.color_intro_page3))
            viewBinding.next.text = "COMPLETE"
        } else {
            viewBinding.next.text = "NEXT"
            viewBinding.navContainer.setBackgroundColor(resources.getColor(R.color.intro_background))
        }
        viewBinding.motionLayout.motionLayout.setTransition(startId, endId)
        viewBinding.motionLayout.motionLayout.transitionToEnd()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            updateIndicators()
        }
    }

    private fun updateIndicators() {
        indicators.forEachIndexed { index, view ->
            val background = when (index) {
                currentPosition -> R.drawable.intro_selected_dot
                else -> R.drawable.intro_unselected_dot
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                view.setBackgroundDrawable(context?.getDrawable(background))
            }
        }
    }

    private fun setIndicators() {
        val dotRadius: Int = convertDpToPixel(12f, context)
        val margin: Int = convertDpToPixel(4f, context)
        indicators.clear()
        viewBinding.indicatorsContainer.removeAllViews()
        for (i in 0 until 3) {
            val view = View(context)
            view.id = View.generateViewId()
            val layoutParams = FrameLayout.LayoutParams(dotRadius * 2, dotRadius * 2)
            layoutParams.setMargins(margin, margin, margin, margin)
            view.layoutParams = layoutParams
            indicators.add(view)
            viewBinding.indicatorsContainer.addView(view)
        }
    }

    private fun convertDpToPixel(dp: Float, context: Context?): Int {
        if (context != null) {
            val px =
                (dp * (context.resources.displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT))
            return px.toInt()
        }
        return 0
    }
}
