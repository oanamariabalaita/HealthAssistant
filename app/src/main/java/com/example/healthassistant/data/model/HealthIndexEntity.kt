package com.example.healthassistant.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
@Entity(tableName = "health_index")
data class HealthIndexEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long,

    @PrimaryKey()
    @ColumnInfo(name = "userId")
    var userId: Long,

    @ColumnInfo(name = "name")
    var indexName: String,

    @ColumnInfo(name = "img")
    var imgId: String,

    @ColumnInfo(name = "descriptive")
    var descriptiveVal: String,

    @ColumnInfo(name = "quantitative")
    var quantitativeVal: Float? = null,

    @ColumnInfo(name = "unit")
    var unit: String? = null,

    @ColumnInfo(name = "recorded")
    var recordedAt: String,

    @Transient
    @ColumnInfo(name = "selected")
    var isSelected: Boolean = false
)
