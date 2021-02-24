package com.example.healthassistant.presentation.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.healthassistant.presentation.MainViewModel
import com.example.healthassistant.presentation.di.ViewModelFactory
import com.example.healthassistant.presentation.di.ViewModelKey
import com.example.healthassistant.presentation.features.dashboard.DashboardViewModel
import com.example.healthassistant.presentation.features.notifications.NotificationsViewModel
import com.example.healthassistant.presentation.features.profile.ProfileViewModel
import com.example.healthassistant.presentation.features.settings.SettingsViewModel
import com.example.healthassistant.presentation.features.statistics.StatisticsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(DashboardViewModel::class)
    abstract fun bindDashboardViewModel(
        dashboardViewModel: DashboardViewModel
    ): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(NotificationsViewModel::class)
    abstract fun bindNotificationsViewModel(
        notificationsViewModel: NotificationsViewModel
    ): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel::class)
    abstract fun bindProfileViewModel(
        profileViewModel: ProfileViewModel
    ): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SettingsViewModel::class)
    abstract fun bindSettingsViewModel(
        settingsViewModel: SettingsViewModel
    ): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(StatisticsViewModel::class)
    abstract fun bindStatisticsViewModel(
        statisticsViewModel: StatisticsViewModel
    ): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(
        mainViewModel: MainViewModel
    ): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
