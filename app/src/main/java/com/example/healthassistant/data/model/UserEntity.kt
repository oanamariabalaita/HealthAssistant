package com.example.healthassistant.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "user")
data class UserEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Long,

    @ColumnInfo(name = "name")
    val userName: String,

    @ColumnInfo(name = "gender")
    val userGender: String,

    @ColumnInfo(name = "birthyear")
    val userBirthYear: Int,

    @ColumnInfo(name = "height")
    val userHeight: Float,

    @ColumnInfo(name = "weight")
    val userWeight: Float,

    @ColumnInfo(name = "activity")
    val userActivityLevel: String
)
