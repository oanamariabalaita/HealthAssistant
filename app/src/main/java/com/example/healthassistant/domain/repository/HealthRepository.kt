package com.example.healthassistant.domain.repository

import com.example.healthassistant.data.api.HealthApiService
import com.example.healthassistant.data.db.HealthDao
import com.example.healthassistant.domain.utils.extensions.toModel

class HealthRepository(
    private val healthDao: HealthDao,
    private val healthService: HealthApiService
) : BaseRepository() {

    suspend fun getHealthIndices(userId: String) =
        apiRequest {
            healthService
                .getIndicesList(userId)
                .map { it.toModel }
        }

    suspend fun getHealthSummary(userId: String) =
        apiRequest {
            healthService
                .getHealthSumamry(userId)
                .toModel
        }
}
