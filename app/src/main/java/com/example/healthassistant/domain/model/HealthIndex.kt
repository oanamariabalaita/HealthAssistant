package com.example.healthassistant.domain.model

data class HealthIndex(
    val id: String,
    val userId: String,
    val indexName: String,
    var imgId: String,
    var descriptiveVal: String,
    var quantitativeVal: Float?,
    var unit: String?,
    var recordedAt: String,
    var isSelected: Boolean
)
