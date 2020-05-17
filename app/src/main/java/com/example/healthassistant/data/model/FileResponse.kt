package com.example.healthassistant.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FileResponse(val id: String, val url: String) : Parcelable
