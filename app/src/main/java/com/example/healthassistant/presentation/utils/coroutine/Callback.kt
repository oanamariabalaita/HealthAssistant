package com.example.healthassistant.presentation.utils.coroutine

interface Callback<T> {

    fun onComplete(data: T)

    fun onError(error: Throwable)
}
