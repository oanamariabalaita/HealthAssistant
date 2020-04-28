package com.example.healthassistant.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.healthassistant.data.model.HealthIndicator

@Database(entities = [(HealthIndicator::class)], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun healthDao(): HealthDao
}

