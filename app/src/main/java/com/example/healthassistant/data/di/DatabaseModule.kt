package com.example.healthassistant.data.di

import android.content.Context
import com.example.healthassistant.data.db.AppDatabase
import com.example.healthassistant.data.db.HealthDao
import com.example.healthassistant.data.db.UserDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    fun provideHealthDao(db: AppDatabase): HealthDao {
        return db.healthDao()
    }

    @Provides
    fun provideUserDao(db: AppDatabase): UserDao {
        return db.userDao()
    }

    @Provides
    @Singleton
    internal fun providesAppDatabase(
        applicationContext: Context
    ): AppDatabase = AppDatabase.createAppDatabase(applicationContext)
}
