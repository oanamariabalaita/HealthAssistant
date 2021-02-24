package com.example.healthassistant.presentation

import android.app.Application
import com.example.healthassistant.presentation.di.components.AppComponent
import com.example.healthassistant.presentation.di.components.DaggerAppComponent
import com.example.healthassistant.presentation.di.modules.ApplicationModule
import com.facebook.stetho.Stetho
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import timber.log.Timber
import javax.inject.Inject

class HealthApp : Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    private val appComponent: AppComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerAppComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()

        Stetho.initializeWithDefaults(this)
        Timber.plant(Timber.DebugTree())
        this.injectMembers()
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    private fun injectMembers() = appComponent.inject(this)
}
