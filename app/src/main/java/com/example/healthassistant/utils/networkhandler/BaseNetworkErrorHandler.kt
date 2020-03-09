package com.example.healthassistant.utils.networkhandler

import android.content.Context
import com.example.healthassistant.data.ApiPostActionType
import com.example.healthassistant.utils.ApiErrorException
import com.example.healthassistant.utils.network.exceptions.ApiException
import com.example.healthassistant.utils.network.exceptions.ModelMappingException
import com.example.healthassistant.utils.network.exceptions.NetworkException
import timber.log.Timber

abstract class BaseNetworkErrorHandler : INetworkErrorHandler {


    override fun handleError(error: Throwable) {
        Timber.e(error)
        when (error) {
            is ApiException -> {
                handleApiError(error)
            }
            is NetworkException -> {
                showErrorDialog(getMessageFromError(error))
            }
            else -> {
                showErrorDialog(getMessageFromError(error))
            }
        }
    }

    override fun getMessageFromError(error: Throwable): String {
        return when (error) {
            is ApiErrorException -> {
                val apiError = error.apiError
                "${apiError.error?.message} \n\nDEBUG INFO:\n\n" +
                        "Status code: ${error.statusCode}\n\n" +
                        "${apiError.debug}"

            }
            is ModelMappingException -> {
                "Model not match with response JSON\n\nDEBUG INFO\n\n${error.cause?.message}"
            }
            is NetworkException -> {
                "${error.cause.toString()}\n\nDEBUG INFO\n\n${error.cause?.message}"
            }
            else -> error.message ?: "Unknown error"
        }
    }

    override fun hasPostAction(error: Throwable): Boolean =
        (error as? ApiException)?.apiError?.postAction != null ?: false

    protected abstract fun getContext(): Context

    protected abstract fun showErrorDialog(message: String)

    private fun handleApiError(apiException: ApiException) {
        val apiError = apiException.apiError

        when (apiError.postAction) {
            ApiPostActionType.APP_UPGRADE -> {
                //TODO
            }
            ApiPostActionType.LOGOUT -> {
                //TODO
            }
            null -> {
                showErrorDialog(getMessageFromError(apiException))
            }
        }
    }
}