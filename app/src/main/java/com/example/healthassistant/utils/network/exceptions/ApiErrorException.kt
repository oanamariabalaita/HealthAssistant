package com.example.healthassistant.utils.network.exceptions

import com.example.healthassistant.data.ApiError
import retrofit2.HttpException

class ApiErrorException(httpException: HttpException, apiError: ApiError) :
    ApiException(apiError, httpException.code(), httpException)