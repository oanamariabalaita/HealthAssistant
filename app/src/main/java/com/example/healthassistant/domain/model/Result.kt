package com.example.healthassistant.domain.model

sealed class Result<T> {
    data class Success<T>(val data: T) : Result<T>()
    data class Error(val exception: Throwable) : Result<Nothing>()

    fun execute(
        success: ((T) -> Unit)? = null,
        error: ((Throwable) -> Unit)? = null,
        before: (() -> Unit)? = null,
        after: (() -> Unit)? = null
    ) {
        before?.invoke()
        when (this) {
            is Success -> success?.invoke(data)
            is Error -> error?.invoke(exception)
        }
        after?.invoke()
    }
}
