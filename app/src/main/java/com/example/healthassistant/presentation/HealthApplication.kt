package com.example.healthassistant.presentation

import android.app.Application
import com.example.healthassistant.data.di.databaseModule
import com.example.healthassistant.data.di.networkModule
import com.example.healthassistant.domain.di.interactionModule
import com.example.healthassistant.presentation.di.applicationModule
import com.example.healthassistant.presentation.di.viewModelModule
import com.facebook.stetho.Stetho
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class HealthApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin()
        Stetho.initializeWithDefaults(this)
        Timber.plant(Timber.DebugTree())
    }

    private fun initKoin() {
        startKoin {
            androidLogger()
            androidContext(this@HealthApplication)
            modules(
                applicationModule,
                interactionModule,
                databaseModule,
                networkModule,
                viewModelModule
            )
        }
    }
}
