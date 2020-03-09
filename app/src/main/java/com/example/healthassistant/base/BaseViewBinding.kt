package com.example.healthassistant.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import com.example.healthassistant.utils.navigation.INavigationResult

interface BaseViewBinding<VB : ViewDataBinding> : INavigationResult {

        val viewBinding: VB

        fun createBinding(inflater: LayoutInflater, container: ViewGroup?): VB

        fun onBind(viewBinding: VB)
    }
