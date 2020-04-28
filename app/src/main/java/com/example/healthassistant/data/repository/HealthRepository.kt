package com.example.healthassistant.data.repository

import com.example.healthassistant.data.api.HealthApiService
import com.example.healthassistant.data.local.AppDatabase
import com.example.healthassistant.data.local.HealthDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HealthRepository @Inject constructor(
    private val db: AppDatabase,
    private val healthDao: HealthDao,
    private val healthService: HealthApiService
) : IHealthRepository {

}
