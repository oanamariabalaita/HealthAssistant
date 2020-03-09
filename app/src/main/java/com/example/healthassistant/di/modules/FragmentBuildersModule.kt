package com.example.healthassistant.di.modules

import com.example.healthassistant.ui.DashboardFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    internal abstract fun contributesDashboardFragment(): DashboardFragment
}