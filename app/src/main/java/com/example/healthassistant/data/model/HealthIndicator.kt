package com.example.healthassistant.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "health_indicator")
data class HealthIndicator(

    @Expose
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    @ColumnInfo(name = "id")
    var id: Long,

    @Expose
    @SerializedName("name")
    @ColumnInfo(name = "name")
    var indicatorName: String,

    @Expose
    @SerializedName("img")
    @ColumnInfo(name = "img")
    var imgId: String? = null,

    @Expose
    @SerializedName("descriptive")
    @ColumnInfo(name = "descriptive")
    var descriptiveVal: String? = null,

    @Expose
    @SerializedName("quantitative")
    @ColumnInfo(name = "quantitative")
    var quantitativeVal: Float? = null,

    @Expose
    @SerializedName("unit")
    @ColumnInfo(name = "unit")
    var unit: String? = null,

    @Expose
    @SerializedName("recorded")
    @ColumnInfo(name = "recorded")
    var recordedAt: String? = null,

    @Expose
    @SerializedName("selected")
    @ColumnInfo(name = "selected")
    var isSelected: Boolean? = null

)
