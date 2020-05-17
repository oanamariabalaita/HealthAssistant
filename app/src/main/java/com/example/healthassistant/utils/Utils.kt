package com.example.healthassistant.utils

import android.graphics.Bitmap
import android.os.Environment
import timber.log.Timber
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.IOException

fun scaleImage(bitmap: Bitmap): File? {
    val origWidth = bitmap.width
    val origHeight = bitmap.height
    var destWidth = 0
    var destHeight = 0
    val ratio: Float

    val maxDimension = 1920
    val minDimension = 1080

    if (origWidth > origHeight) {
        if (origWidth > maxDimension || origHeight > minDimension) {
            ratio = origWidth.toFloat().div(origHeight.toFloat())
            if (origWidth.div(maxDimension.toFloat())
                    .compareTo(origHeight.div(minDimension.toFloat())) > 0
            ) {
                destWidth = maxDimension
                destHeight = maxDimension.div(ratio).toInt()
            } else {
                destWidth = minDimension.times(ratio).toInt()
                destHeight = minDimension
            }
            return createScaledBitmap(bitmap, destWidth, destHeight, false)
        }
    } else {
        if (origHeight > maxDimension || origWidth > minDimension) {
            ratio = origHeight.toFloat().div(origWidth.toFloat())
            if (origHeight.div(maxDimension.toFloat())
                    .compareTo(origWidth.div(minDimension.toFloat())) > 0
            ) {
                destHeight = maxDimension
                destWidth = maxDimension.div(ratio).toInt()
            } else {
                destHeight = minDimension.times(ratio).toInt()
                destWidth = minDimension
            }
            return createScaledBitmap(bitmap, destWidth, destHeight, false)
        }
    }
    return createScaledBitmap(bitmap, origWidth, origHeight, false)
}

fun createScaledBitmap(bitmap: Bitmap, destWidth: Int, destHeight: Int, filter: Boolean): File? {
    try {
        val scaledBitmap = Bitmap.createScaledBitmap(bitmap, destWidth, destHeight, filter)
        ByteArrayOutputStream().use { outputStream ->
            scaledBitmap.compress(Bitmap.CompressFormat.JPEG, 70, outputStream)
            return File("${Environment.getExternalStorageDirectory().absolutePath}${File.separator}temp.jpg").apply {
                createNewFile()
                writeBytes(outputStream.toByteArray())
            }
        }
    } catch (e: IOException) {
        Timber.e(e)
    }
    return null
}
