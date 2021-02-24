package com.example.healthassistant.domain.utils.extensions

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

private val dateFormatter = SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.ENGLISH)
private val standardDateFormatter = SimpleDateFormat("dd MMM yyyy HH:mm:ss", Locale.ENGLISH)

fun Date?.toFormattedString(): String = if (this != null) dateFormatter.format(this) else ""

fun String.toFormattedDate(): Date? = standardDateFormatter.parse(this)
