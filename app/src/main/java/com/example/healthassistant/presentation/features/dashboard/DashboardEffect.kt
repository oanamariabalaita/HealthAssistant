package com.example.healthassistant.presentation.features.dashboard

sealed class DashboardEffect {
    data class ShowToast(val message: String) : DashboardEffect()
}
