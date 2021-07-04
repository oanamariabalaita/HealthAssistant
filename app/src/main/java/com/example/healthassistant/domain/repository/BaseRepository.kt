package com.example.healthassistant.domain.repository

import com.example.healthassistant.domain.model.Result
import com.example.healthassistant.domain.utils.exception.DaoException
import com.example.healthassistant.domain.utils.exception.NetworkException
import com.example.healthassistant.domain.utils.exception.UnknownNetworkException
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.UnknownHostException
import java.util.concurrent.TimeoutException
import javax.net.ssl.SSLException

@Suppress("TooGenericExceptionCaught")
open class BaseRepository {

    suspend fun <T> apiRequest(suspendBlock: suspend () -> T) =
        withContext(Dispatchers.IO) {
            try {
                val result = suspendBlock.invoke()
                Result.Success(result)
            } catch (e: Throwable) {
                Result.Error(
                    when (e) {
                        is CancellationException -> e
                        is UnknownHostException,
                        is TimeoutException,
                        is SSLException -> NetworkException(e)
                        else -> UnknownNetworkException(e)
                    }
                )
            }
        }

    suspend fun <T> daoRequest(suspendBlock: suspend () -> T) =
        withContext(Dispatchers.IO) {
            try {
                Result.Success(suspendBlock.invoke())
            } catch (e: Throwable) {
                Result.Error(
                    when (e) {
                        is CancellationException -> e
                        else -> DaoException(e)
                    }
                )
            }
        }
}
