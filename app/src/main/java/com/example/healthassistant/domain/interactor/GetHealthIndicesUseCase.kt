package com.example.healthassistant.domain.interactor

import com.example.healthassistant.domain.model.HealthIndex
import com.example.healthassistant.domain.repository.HealthRepository
import javax.inject.Inject

class GetHealthIndicesUseCase @Inject constructor(private val healthRepository: HealthRepository) :
    UseCase<List<HealthIndex>, GetHealthIndicesUseCase.Params>() {

    override suspend fun run(params: Params) = healthRepository.getHealthIndices(params.id)

    data class Params(val id: String)
}
