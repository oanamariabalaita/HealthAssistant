package com.example.healthassistant.domain.repository

import com.example.healthassistant.data.api.HealthApiService
import com.example.healthassistant.data.db.HealthDao
import com.example.healthassistant.domain.utils.networking.toModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HealthRepository @Inject constructor(
    private val healthDao: HealthDao,
    private val healthService: HealthApiService
) : BaseRepository() {

    suspend fun getHealthIndices(userId: String) =
        apiRequest {
            healthService
                .getIndicesList(userId)
                .map { it.toModel() }
        }
//            .also { apiResult ->
//            when (apiResult) {
//                is Result.Success -> {
//                    daoRequest {
//                        healthDao.postIndicesList(userId, apiResult.data.map { it.toEntity() })
//                    }
//                }
//                is Result.Error -> {
//                    daoRequest {
//                        healthDao
//                            .getIndicesList(userId)
//                            .map { it.toModel() }
//                    }
//                }
//            }
//        }
}
