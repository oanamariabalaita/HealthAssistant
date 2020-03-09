package com.example.healthassistant.utils.network

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ErrorDialogConfig(
    val negativeButtonEnabled: Boolean,
    val positiveButtonEnabled: Boolean,
    val negativeButtonLocRes: Int?,
    val positiveButtonLocRes: Int?
) : Parcelable