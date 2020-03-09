package com.example.healthassistant.utils.loading

import android.graphics.drawable.Animatable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.healthassistant.databinding.LoadingBinding

class LoadingHandler {

    companion object {

        private const val LOADING_VIEW_TAG = "loadingViewTag"

    }

    fun getDefaultLoadingView(layoutInflater: LayoutInflater): View =
        LoadingBinding.inflate(layoutInflater).also {
            (it.progressImage.drawable as Animatable).start()
        }.root

    fun setViewLoadingForView(
        parentView: ViewGroup,
        visible: Boolean,
        loadingView: View
    ): View? {
        val oldLoadingView = parentView.findViewWithTag<View>(LOADING_VIEW_TAG + parentView.id)

        return if (oldLoadingView == null) {
            if (visible) {
                initLoadingView(loadingView, parentView)
                parentView.addView(
                    loadingView,
                    ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )
                )
                loadingView
            } else null
        } else {
            if (visible) {
                oldLoadingView
            } else {
                parentView.removeView(oldLoadingView)
                null
            }
        }
    }

    private fun initLoadingView(loadingView: View, parentView: View) {
        loadingView.isClickable = true // consume touch events over loading view
        loadingView.tag = LOADING_VIEW_TAG + parentView.id
    }
}