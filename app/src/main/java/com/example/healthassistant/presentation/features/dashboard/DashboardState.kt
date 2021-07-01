package com.example.healthassistant.presentation.features.dashboard

import com.example.healthassistant.domain.model.HealthIndex
import kotlinx.coroutines.flow.MutableStateFlow

data class DashboardState(
    val indices: List<HealthIndex> = listOf(),
    val healthIndicesLoading: Boolean = true,
    val userName: String = "",
    val summaryLoading: Boolean = true
)

fun MutableStateFlow<DashboardState>.update(
    indices: List<HealthIndex> = value.indices,
    healthIndicesLoading: Boolean = value.healthIndicesLoading,
    user: String = value.userName,
    summaryLoading: Boolean = value.summaryLoading
) {
    value = value.copy(
        indices = indices,
        healthIndicesLoading = healthIndicesLoading,
        userName = user,
        summaryLoading = summaryLoading
    )
}
