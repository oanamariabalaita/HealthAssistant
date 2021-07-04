package com.example.healthassistant.data.api

import com.example.healthassistant.data.model.HealthIndexEntity
import com.example.healthassistant.data.model.HealthSummaryEntity
import retrofit2.http.GET
import retrofit2.http.Path

interface HealthApiService {

    companion object EP {
        private const val PREFIX = "health/"
        private const val GET_INDEX = "$PREFIX/index/{userId}/{indexId}"
        private const val GET_INDICES_LIST = "$PREFIX/index/{userId}"
        private const val GET_HEALTH_SUMMARY = "$PREFIX/summary/{userId}"
        private const val GET_TEST = "$PREFIX/index/{userId}/test"
    }

    @GET(GET_INDEX)
    suspend fun getHealthIndex(
        @Path("userId") userId: String,
        @Path("indexId") indexId: String
    ): HealthIndexEntity

    @GET(GET_INDICES_LIST)
    suspend fun getIndicesList(
        @Path("userId") userId: String
    ): List<HealthIndexEntity>

    @GET(GET_HEALTH_SUMMARY)
    suspend fun getHealthSumamry(
        @Path("userId") userId: String
    ): HealthSummaryEntity

    @GET(GET_TEST)
    suspend fun getTest(
        @Path("userId") userId: String
    ): List<HealthIndexEntity>
}
