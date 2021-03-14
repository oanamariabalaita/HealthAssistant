package com.example.healthassistant.presentation.features.dashboard

import androidx.compose.runtime.Immutable
import com.example.healthassistant.domain.model.HealthIndex
import com.example.healthassistant.domain.model.User

@Immutable
sealed class HealthIndicesViewState {
    data class Success(val indices: List<HealthIndex>) : HealthIndicesViewState()
    data class Error(val exception: Throwable) : HealthIndicesViewState()
}

@Immutable
sealed class UserViewState {
    data class Success(val user: User) : UserViewState()
    data class Error(val exception: Throwable) : UserViewState()
    object Empty : UserViewState()
}
