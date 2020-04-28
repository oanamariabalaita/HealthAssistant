package com.example.healthassistant.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "user")
data class User(

    @Expose
    @PrimaryKey(autoGenerate = true)
    var id: Long,

    @Expose
    @SerializedName("name")
    @ColumnInfo(name = "name")
    var userName: String,

    @Expose
    @SerializedName("gender")
    @ColumnInfo(name = "gender")
    var userGender: String,

    @Expose
    @SerializedName("birthyear")
    @ColumnInfo(name = "birthyear")
    var userBirthYear: Int,

    @Expose
    @SerializedName("height")
    @ColumnInfo(name = "height")
    var userHeight: Float,

    @Expose
    @SerializedName("weight")
    @ColumnInfo(name = "weight")
    var userWeight: Float,

    @Expose
    @SerializedName("activity")
    @ColumnInfo(name = "activity")
    var userActivityLevel: String
)
