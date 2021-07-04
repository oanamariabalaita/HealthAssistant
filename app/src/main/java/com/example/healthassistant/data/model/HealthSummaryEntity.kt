package com.example.healthassistant.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "health_summary")
data class HealthSummaryEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: String,

    @ColumnInfo(name = "userId")
    var healthScore: Float,
)
