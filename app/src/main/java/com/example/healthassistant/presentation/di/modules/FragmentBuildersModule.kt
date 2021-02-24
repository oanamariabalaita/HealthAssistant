package com.example.healthassistant.presentation.di.modules

import com.example.healthassistant.presentation.di.PerFragment
import com.example.healthassistant.presentation.features.dashboard.DashboardFragment
import com.example.healthassistant.presentation.features.intro.IntroFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {

    @PerFragment
    @ContributesAndroidInjector
    abstract fun contributeIntroFragment(): IntroFragment

    @PerFragment
    @ContributesAndroidInjector
    abstract fun contributeDashboardFragment(): DashboardFragment
}
