package com.example.healthassistant.presentation.features.dashboard

sealed class DashboardEvent
data class OpenCardDetails(val userId: Long, val cardId: Long) : DashboardEvent()
object OpenSummary : DashboardEvent()
object Refresh : DashboardEvent()
object OpenMenu : DashboardEvent()
