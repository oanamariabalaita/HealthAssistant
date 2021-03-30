package com.example.healthassistant.presentation.di.modules

import android.content.Context
import com.example.healthassistant.data.di.DatabaseModule
import com.example.healthassistant.data.di.NetworkingModule
import com.example.healthassistant.domain.di.InteractionModule
import com.example.healthassistant.presentation.HealthApplication
import dagger.Module
import dagger.Provides
import java.io.File
import javax.inject.Named
import javax.inject.Singleton

@Module(
    includes = [
        ViewModelModule::class,
        DatabaseModule::class,
        NetworkingModule::class,
        InteractionModule::class]
)
class ApplicationModule(private val application: HealthApplication) {

    @Provides
    @Singleton
    fun providesApplicationContext(): Context = application

    @Provides
    @Singleton
    @Named("cache")
    fun provideCacheDir(): File = application.cacheDir

    @Singleton
    @Provides
    fun provideApplicationId(): String = application.packageName

}
