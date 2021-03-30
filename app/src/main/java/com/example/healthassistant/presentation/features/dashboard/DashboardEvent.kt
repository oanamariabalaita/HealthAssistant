package com.example.healthassistant.presentation.features.dashboard

interface DashboardEvent {
    fun onCardDetailsClick(cardId: Long)
    fun onHealthSummaryClick()
    fun onStatisticsClick()
    fun onRefreshSwipe()
}
