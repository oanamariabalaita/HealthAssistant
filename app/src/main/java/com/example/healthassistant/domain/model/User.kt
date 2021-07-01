package com.example.healthassistant.domain.model

data class User(
    val id: String,
    val userName: String,
    val userGender: String?,
    val userBirthYear: Int?,
    val userHeight: Float?,
    val userWeight: Float?,
    val userActivityLevel: String?
)
