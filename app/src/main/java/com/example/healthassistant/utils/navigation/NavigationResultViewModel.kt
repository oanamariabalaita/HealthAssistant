package com.example.healthassistant.utils.navigation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import com.example.healthassistant.utils.livedata.Event
import com.example.healthassistant.utils.livedata.observeEvent
import com.github.mustafaozhan.basemob.viewmodel.BaseViewModel
import javax.inject.Inject

class NavigationResultViewModel @Inject constructor() : BaseViewModel() {

    private val navigationResults = mutableMapOf<String, MutableLiveData<Event<NavigationResult>>>()

    fun produceNavigationResult(tag: String, result: NavigationResult) {
        getOrCreateObserver(tag).value =
            Event(result)
    }

    fun observeNavigationResult(
        tag: String,
        lifecycleOwner: LifecycleOwner,
        result: (data: NavigationResult) -> Unit
    ) = getOrCreateObserver(tag).observeEvent(lifecycleOwner) {
        result.invoke(it)
    }

    private fun getOrCreateObserver(tag: String): MutableLiveData<Event<NavigationResult>> {
        val observer = navigationResults[tag]

        if (observer != null) {
            return observer
        }

        val newObserver = MutableLiveData<Event<NavigationResult>>()
        navigationResults[tag] = newObserver
        return newObserver
    }
}
