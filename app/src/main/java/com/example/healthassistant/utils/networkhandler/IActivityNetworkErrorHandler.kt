package com.example.healthassistant.utils.networkhandler

import android.content.Context
import androidx.fragment.app.FragmentManager

interface IActivityNetworkErrorHandler {

    fun setFragmentManager(fragmentManager: FragmentManager)

    fun setContext(context: Context)
}