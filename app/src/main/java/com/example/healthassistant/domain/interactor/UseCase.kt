package com.example.healthassistant.domain.interactor

import com.example.healthassistant.domain.model.Result
import kotlinx.coroutines.withTimeout
import java.util.concurrent.TimeUnit

abstract class UseCase<out Type, in Params> where Type : Any {

    companion object {
        private val defaultTimeoutMs = TimeUnit.MINUTES.toMillis(5)
    }

    suspend operator fun invoke(params: Params, timeoutMs: Long = defaultTimeoutMs) {
        withTimeout(timeoutMs) {
            run(params)
        }
    }

    abstract suspend fun run(params: Params): Result<out Type>
}
