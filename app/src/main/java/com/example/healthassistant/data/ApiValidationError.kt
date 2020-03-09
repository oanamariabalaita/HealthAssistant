package com.example.healthassistant.data

data class ApiValidationError(
    val propertyPath: String,
    val message: String,
    val messageCode: String
)