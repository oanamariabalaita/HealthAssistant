package com.example.healthassistant.utils.coroutine

import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

suspend fun <T> awaitCallback(block: (Callback<T>) -> Unit): T =
    suspendCancellableCoroutine { continuation ->
        block(object : Callback<T> {

            override fun onComplete(data: T) {
                continuation.resume(data)
            }

            override fun onError(error: Throwable) {
                continuation.resumeWithException(error)
            }
        })
    }