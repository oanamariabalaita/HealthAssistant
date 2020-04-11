package com.example.healthassistant.data.remote

import com.example.healthassistant.data.HealthService
import com.example.healthassistant.utils.ApplicationExecutors
import javax.inject.Inject


class HealthIndicatorRepository @Inject constructor(
    private val appExecutors: ApplicationExecutors,
    private val healthService: HealthService
) : IHealthIndicatorRepository {
}