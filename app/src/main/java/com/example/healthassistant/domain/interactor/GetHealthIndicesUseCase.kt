package com.example.healthassistant.domain.interactor

import android.content.Context
import com.example.healthassistant.R
import com.example.healthassistant.data.model.HealthIndexEntity
import com.example.healthassistant.domain.model.HealthIndex
import com.example.healthassistant.domain.model.Result
import com.example.healthassistant.domain.repository.HealthRepository
import com.example.healthassistant.domain.utils.extensions.toModel
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.io.InputStream
import java.util.Scanner

class GetHealthIndicesUseCase(
    private val applicationContext: Context,
    private val healthRepository: HealthRepository
) :
    UseCase<List<HealthIndex>, GetHealthIndicesUseCase.Params>() {

    val string = applicationContext.resources
        .openRawResource(R.raw.indices_mock)
    val index = Json.decodeFromString<List<HealthIndexEntity>>(
        """${convertStreamToString(string)}"""
    )
    val mock = index.map { it.toModel }

    override suspend fun run(params: Params) = healthRepository.getHealthIndices(params.id).also {
        if (it is Result.Error) {
            return@run Result.Success(mock)
        }
    }

    data class Params(val id: String)
}

fun convertStreamToString(x: InputStream?): String
? {
    val s = Scanner(x).useDelimiter("\\A")
    return if (s.hasNext()) s.next() else ""
}
