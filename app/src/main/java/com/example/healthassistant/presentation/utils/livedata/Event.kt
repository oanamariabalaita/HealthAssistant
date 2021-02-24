package com.example.healthassistant.presentation.utils.livedata

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.observe
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.transform

/**
 * Returns a flow which performs the given [action] on each value of the original flow's [Event].
 */
fun <T> Flow<Event<T?>>.onEachEvent(action: suspend (T) -> Unit): Flow<T> = transform { value ->
    value.getContentIfNotHandled()?.let {
        action(it)
        return@transform emit(it)
    }
}

open class Event<out T>(private val content: T) {

    private var hasBeenHandled = false

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
