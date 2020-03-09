package com.example.healthassistant.utils.navigation

import androidx.lifecycle.LifecycleOwner

interface INavigationResult {

    fun observeNavigationResult(
        tag: String,
        lifecycleOwner: LifecycleOwner,
        callback: (navigationResult: NavigationResult) -> Unit = {}
    )

    fun setNavigationResult(tag: String, navigationResult: NavigationResult)

}
