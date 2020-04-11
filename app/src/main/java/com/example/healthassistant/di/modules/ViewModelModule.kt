package com.example.healthassistant.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.healthassistant.di.ViewModelFactory
import com.example.healthassistant.di.ViewModelKey
import com.example.healthassistant.ui.dashboard.DashboardViewModel
import com.github.mustafaozhan.basemob.view.BaseViewEffect
import com.github.mustafaozhan.basemob.view.BaseViewEvent
import com.github.mustafaozhan.basemob.view.BaseViewState
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(DashboardViewModel::class)
    abstract fun bindDashboardViewModel(dashboardViewModel: DashboardViewModel<BaseViewEffect, BaseViewEvent, BaseViewState>): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
