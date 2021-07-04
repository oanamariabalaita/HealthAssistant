package com.example.healthassistant.presentation.features.dashboard

import com.example.healthassistant.domain.model.HealthIndex
import kotlinx.coroutines.flow.MutableStateFlow

data class DashboardState(
    val indices: List<HealthIndex> = listOf(),
    val healthIndicesLoading: Boolean = true,
    val userName: String = "",
    val healthSummaryScore: Float = 0.0f,
    val summaryLoading: Boolean = true
)

fun MutableStateFlow<DashboardState>.update(
    indices: List<HealthIndex> = value.indices,
    healthIndicesLoading: Boolean = value.healthIndicesLoading,
    user: String = value.userName,
    healthSummaryScore: Float = value.healthSummaryScore,
    summaryLoading: Boolean = value.summaryLoading
) {
    value = value.copy(
        indices = indices,
        healthIndicesLoading = healthIndicesLoading,
        userName = user,
        healthSummaryScore = healthSummaryScore,
        summaryLoading = summaryLoading
    )
}
