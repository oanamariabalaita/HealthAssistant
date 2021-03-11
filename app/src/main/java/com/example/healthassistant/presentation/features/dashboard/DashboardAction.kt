package com.example.healthassistant.presentation.features.dashboard

sealed class DashboardAction {
    data class NavigateToCardDetails(val userId: Long, val cardId: Long) : DashboardAction()
    object NavigateToStatistics : DashboardAction()
    object Refresh : DashboardAction()
}
