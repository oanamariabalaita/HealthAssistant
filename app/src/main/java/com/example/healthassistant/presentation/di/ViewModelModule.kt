package com.example.healthassistant.presentation.di

import com.example.healthassistant.presentation.features.cardDetails.CardDetailsViewModel
import com.example.healthassistant.presentation.features.dashboard.DashboardViewModel
import com.example.healthassistant.presentation.features.notifications.NotificationsViewModel
import com.example.healthassistant.presentation.features.profile.ProfileViewModel
import com.example.healthassistant.presentation.features.settings.SettingsViewModel
import com.example.healthassistant.presentation.features.statistics.StatisticsViewModel
import com.example.healthassistant.presentation.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { DashboardViewModel(get(), get()) }
    viewModel { MainViewModel() }
    viewModel { NotificationsViewModel() }
    viewModel { ProfileViewModel() }
    viewModel { SettingsViewModel() }
    viewModel { StatisticsViewModel() }
    viewModel { CardDetailsViewModel() }
}
