package com.example.healthassistant.presentation.di.components

import com.example.healthassistant.presentation.HealthApp
import com.example.healthassistant.presentation.di.modules.ApplicationModule
import com.example.healthassistant.presentation.di.modules.MainActivityModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,
        ApplicationModule::class,
        MainActivityModule::class]
)
interface AppComponent : AndroidInjector<HealthApp> {

    override fun inject(application: HealthApp)

}
