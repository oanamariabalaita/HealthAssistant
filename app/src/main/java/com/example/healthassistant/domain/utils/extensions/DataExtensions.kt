package com.example.healthassistant.domain.utils.extensions

import com.example.healthassistant.data.model.HealthIndexEntity
import com.example.healthassistant.data.model.UserEntity
import com.example.healthassistant.domain.model.HealthIndex
import com.example.healthassistant.domain.model.User

internal val UserEntity.toModel: User
    get() = User(
        id = id.toString(),
        userName = userName,
        userGender = userGender,
        userBirthYear = userBirthYear,
        userHeight = userHeight,
        userWeight = userWeight,
        userActivityLevel = userActivityLevel
    )

internal val User.toEntity: UserEntity
    get() = UserEntity(
        id = id.toLong(),
        userName = userName,
        userGender = userGender,
        userBirthYear = userBirthYear,
        userHeight = userHeight,
        userWeight = userWeight,
        userActivityLevel = userActivityLevel
    )

internal val HealthIndexEntity.toModel: HealthIndex
    get() = HealthIndex(
        id = id.toString(),
        userId = userId.toString(),
        indexName = indexName,
        imgId = imgId,
        descriptiveVal = descriptiveVal,
        quantitativeVal = quantitativeVal,
        unit = unit,
        recordedAt = recordedAt,
        isSelected = isSelected
    )

internal val HealthIndex.toEntity: HealthIndexEntity
    get() = HealthIndexEntity(
        id = id.toLong(),
        userId = userId.toLong(),
        indexName = indexName,
        imgId = imgId,
        descriptiveVal = descriptiveVal,
        quantitativeVal = quantitativeVal,
        unit = unit,
        recordedAt = recordedAt,
        isSelected = isSelected
    )
