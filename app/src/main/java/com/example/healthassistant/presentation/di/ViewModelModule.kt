package com.example.healthassistant.presentation.di

import com.example.healthassistant.presentation.features.dashboard.DashboardViewModel
import com.example.healthassistant.presentation.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { DashboardViewModel(get(), get()) }
    viewModel { MainViewModel() }
}
