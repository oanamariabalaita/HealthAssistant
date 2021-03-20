package com.example.healthassistant.presentation.features.dashboard

interface DashboardEvent {
    fun onCardDetailsClick(userId: Long, cardId: Long)
    fun onStatisticsClick()
    fun onRefreshSwipe()
}
