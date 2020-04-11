package com.example.healthassistant.app

import android.app.Application
import com.example.healthassistant.BuildConfig
import com.example.healthassistant.di.components.DaggerAppComponent
import com.facebook.stetho.Stetho
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import timber.log.Timber
import javax.inject.Inject

class App : Application(), HasAndroidInjector {

    companion object {
        lateinit var instance: App
    }

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) Stetho.initializeWithDefaults(this)

        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
        else {
            // TODO
        }

        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)

        instance = this

    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

}