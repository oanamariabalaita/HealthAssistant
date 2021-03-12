package com.example.healthassistant.presentation.di.modules

import com.example.healthassistant.presentation.features.splash.SplashActivity
import com.example.healthassistant.presentation.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class MainActivityModule {

    @ContributesAndroidInjector()
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun contributeSplashActivity(): SplashActivity
}
