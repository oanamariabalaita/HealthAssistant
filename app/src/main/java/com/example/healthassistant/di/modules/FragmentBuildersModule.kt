package com.example.healthassistant.di.modules

import com.example.healthassistant.di.PerFragment
import com.example.healthassistant.ui.dashboard.DashboardFragment
import com.example.healthassistant.ui.intro.IntroFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentBuildersModule {

    @PerFragment
    @ContributesAndroidInjector
    abstract fun contributeIntroFragment(): IntroFragment

    @PerFragment
    @ContributesAndroidInjector
    abstract fun contributeDashboardFragment(): DashboardFragment
}
