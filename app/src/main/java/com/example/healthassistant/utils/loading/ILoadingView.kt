package com.example.healthassistant.utils.loading

import android.view.View
import android.view.ViewGroup

interface ILoadingView {

    fun setFullScreenLoading(visible: Boolean): View?

    fun setViewLoading(parentView: ViewGroup, visible: Boolean): View?
}