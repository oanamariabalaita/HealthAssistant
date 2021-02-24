package com.example.healthassistant.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.healthassistant.data.model.HealthIndexEntity
import com.example.healthassistant.data.model.UserEntity

@Database(
    entities = [
        HealthIndexEntity::class,
        UserEntity::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    companion object {

        private const val DATABASE_NAME = "health_database.sqlite"

        internal fun createAppDatabase(context: Context): AppDatabase = Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            DATABASE_NAME
        ).createFromAsset(DATABASE_NAME)
            .build()
    }

    abstract fun healthDao(): HealthDao

    abstract fun userDao(): UserDao
}

