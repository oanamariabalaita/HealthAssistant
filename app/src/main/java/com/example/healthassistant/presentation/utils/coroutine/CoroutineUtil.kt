package com.example.healthassistant.presentation.utils.coroutine

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
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

fun <T> Flow<T>.launchWhenStartedUntilStopped(lifecycleOwner: LifecycleOwner) {
    if (lifecycleOwner.lifecycle.currentState == Lifecycle.State.DESTROYED) {
        return
    }
    lifecycleOwner.lifecycle.addObserver(LifecycleBoundObserver(this))
}

private class LifecycleBoundObserver(private val flow: Flow<*>) : DefaultLifecycleObserver {
    private var job: Job? = null

    override fun onStart(owner: LifecycleOwner) {
        job = flow.launchIn(owner.lifecycleScope)
//
//        job = owner.lifecycleScope.launch {
//            flow.collect {
//                collector(it)
//            }
//        }
    }

    override fun onStop(owner: LifecycleOwner) {
        cancelJob()
    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        owner.lifecycle.removeObserver(this)
        cancelJob()
    }

    @Suppress("NOTHING_TO_INLINE")
    private inline fun cancelJob() {
        job?.cancel()
        job = null
    }
}
