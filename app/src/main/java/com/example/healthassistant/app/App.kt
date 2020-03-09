package com.example.healthassistant.app

import android.app.Activity
import android.app.Application
import com.example.healthassistant.BuildConfig
import com.facebook.stetho.Stetho
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import timber.log.Timber
import javax.inject.Inject

class App : Application(), HasActivityInjector {

    companion object {
        lateinit var instance: App
    }

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

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

    override fun activityInjector() = dispatchingAndroidInjector
}