package com.example.healthassistant.utils.network.exceptions

import com.example.healthassistant.data.ApiError

abstract class ApiException(
    open val apiError: ApiError,
    open val statusCode: Int,
    cause: Throwable
) : NetworkException(cause)