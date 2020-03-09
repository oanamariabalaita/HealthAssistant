package com.example.healthassistant.data

data class ApiError(
    val error: ApiErrorObject?,
    val postAction: ApiPostActionType?,
    val validationErrors: List<ApiValidationError>?,
    val debug: Any?
)