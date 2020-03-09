package com.example.healthassistant.utils.coroutine

interface Callback<T> {

    fun onComplete(data: T)

    fun onError(error: Throwable)
}