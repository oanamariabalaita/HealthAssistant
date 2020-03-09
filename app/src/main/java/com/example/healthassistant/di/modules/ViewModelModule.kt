package com.example.healthassistant.di.modules

import com.example.healthassistant.ui.DashboardViewModel
import dagger.Module
import dagger.Provides

@Module
abstract class ViewModelModule {

    @Provides
    fun providesDashboardViewModel() = DashboardViewModel()

}
