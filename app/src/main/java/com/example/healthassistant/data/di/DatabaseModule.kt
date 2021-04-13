package com.example.healthassistant.data.di

import androidx.room.Room
import com.example.healthassistant.R
import com.example.healthassistant.data.db.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            AppDatabase::class.java,
            androidApplication().baseContext.getString(R.string.app_name)
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    single {
        get<AppDatabase>().healthDao()
    }
    single {
        get<AppDatabase>().userDao()
    }
}
