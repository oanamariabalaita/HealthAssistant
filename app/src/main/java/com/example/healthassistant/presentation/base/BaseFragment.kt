package com.example.healthassistant.presentation.base

import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    fun setViewLoading(visible: Boolean) {}

    fun handleError(e: Throwable) {}

}

