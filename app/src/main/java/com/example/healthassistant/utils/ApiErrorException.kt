package com.example.healthassistant.utils

import com.example.healthassistant.data.ApiError
import com.example.healthassistant.utils.network.exceptions.ApiException
import retrofit2.HttpException

class ApiErrorException(httpException: HttpException, apiError: ApiError) :
    ApiException(apiError, httpException.code(), httpException)