package com.example.healthassistant.di.modules

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.healthassistant.app.App
import com.example.healthassistant.data.api.HealthApiService
import com.example.healthassistant.data.local.AppDatabase
import com.example.healthassistant.data.local.HealthDao
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class ApplicationModule {

    @Singleton
    @Provides
    internal fun providesApplication(application: App): Application = application

    @Singleton
    @Provides
    internal fun providesContext(application: App): Context = application.applicationContext

    @Singleton
    @Provides
    fun provideHealthApiService(): HealthApiService {
        return Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(HealthApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideDb(app: Application): AppDatabase {
        return Room
            .databaseBuilder(app, AppDatabase::class.java, "health")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideHealthDao(db: AppDatabase): HealthDao {
        return db.healthDao()
    }
}
