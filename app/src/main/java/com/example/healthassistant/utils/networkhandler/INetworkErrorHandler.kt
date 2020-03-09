package com.example.healthassistant.utils.networkhandler

import com.example.healthassistant.R
import com.example.healthassistant.utils.network.ErrorDialogConfig

interface INetworkErrorHandler {

    fun getMessageFromError(error: Throwable): String

    fun handleError(error: Throwable)

    fun hasPostAction(error: Throwable): Boolean

    fun handleError(
        error: Throwable,
        requestCode: Int,
        config: ErrorDialogConfig = ErrorDialogConfig(
            negativeButtonEnabled = false,
            positiveButtonEnabled = true,
            negativeButtonLocRes = null,
            positiveButtonLocRes = R.string.general_ok
        )
    )
}