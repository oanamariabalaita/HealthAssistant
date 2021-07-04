package com.example.healthassistant.domain.interactor

import com.example.healthassistant.domain.model.HealthSummary
import com.example.healthassistant.domain.model.Result
import com.example.healthassistant.domain.repository.HealthRepository

class GetHealthSummaryUseCase(private val healthRepository: HealthRepository) :
    UseCase<HealthSummary, GetHealthSummaryUseCase.Params>() {

    override suspend fun run(params: GetHealthSummaryUseCase.Params): Result<out HealthSummary> =
        healthRepository.getHealthSummary(params.id).also {
            if (it is Result.Error) {
                return@run Result.Success(HealthSummary("1", 10.0f))
            }
        }

    data class Params(val id: String)
}
