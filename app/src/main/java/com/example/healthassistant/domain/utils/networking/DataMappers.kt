package com.example.healthassistant.domain.utils.networking

import com.example.healthassistant.data.model.HealthIndexEntity
import com.example.healthassistant.data.model.UserEntity
import com.example.healthassistant.domain.model.HealthIndex
import com.example.healthassistant.domain.model.User

fun UserEntity.toModel() = User(
    id = id.toString(),
    userName = userName,
    userGender = userGender,
    userBirthYear = userBirthYear,
    userHeight = userHeight,
    userWeight = userWeight,
    userActivityLevel = userActivityLevel
)

fun User.toEntity() = UserEntity(
    id = id.toLong(),
    userName = userName,
    userGender = userGender,
    userBirthYear = userBirthYear,
    userHeight = userHeight,
    userWeight = userWeight,
    userActivityLevel = userActivityLevel
)

fun HealthIndexEntity.toModel() = HealthIndex(
    id = id.toString(),
    indexName = indexName,
    imgId = imgId,
    descriptiveVal = descriptiveVal,
    quantitativeVal = quantitativeVal,
    unit = unit,
    recordedAt = recordedAt,
    isSelected = isSelected
)

fun HealthIndex.toEntity() = HealthIndexEntity(
    id = id.toLong(),
    indexName = indexName,
    imgId = imgId,
    descriptiveVal = descriptiveVal,
    quantitativeVal = quantitativeVal,
    unit = unit,
    recordedAt = recordedAt,
    isSelected = isSelected
)
