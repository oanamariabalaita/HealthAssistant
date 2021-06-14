package com.example.healthassistant.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "health_index")
data class HealthIndexEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long,

    @ColumnInfo(name = "userId")
    var userId: Long,

    @SerialName("name")
    @ColumnInfo(name = "name")
    var indexName: String,

    @SerialName("img")
    @ColumnInfo(name = "img")
    var imgId: String,

    @SerialName("descriptive")
    @ColumnInfo(name = "descriptive")
    var descriptiveVal: String,

    @SerialName("quantitative")
    @ColumnInfo(name = "quantitative")
    var quantitativeVal: Float? = null,

    @ColumnInfo(name = "unit")
    var unit: String? = null,

    @SerialName("recorded")
    @ColumnInfo(name = "recorded")
    var recordedAt: String,

    @SerialName("selected")
    @ColumnInfo(name = "selected")
    var isSelected: Boolean = false
)
