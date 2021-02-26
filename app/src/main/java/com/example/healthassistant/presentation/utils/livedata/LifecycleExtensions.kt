package com.example.healthassistant.presentation.utils.livedata

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect

fun <T : Any?> LifecycleOwner.observe(flow: Flow<T>, onChanged: (T) -> Unit) {
    liveData {
        flow.collect {
            emit(it)
        }
    }.observe(this, Observer(onChanged))
}
