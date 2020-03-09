package com.example.healthassistant.utils.livedata

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.observe

open class Event<out T>(private val content: T) {

    var hasBeenHandled = false
        private set

    fun getContentIfNotHandled(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }

    fun peekContent(): T = content
}

class EmptyEvent private constructor() {

    companion object {

        fun create() = EmptyEvent()

    }
}

fun <T, E : Event<T>> LiveData<E>.observeEvent(
    lifecycleOwner: LifecycleOwner,
    callback: (data: T) -> Unit
) {
    observe(lifecycleOwner) {
        it.getContentIfNotHandled()?.let { data ->
            callback(data)
        }
    }
}