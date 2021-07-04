package com.example.healthassistant.domain.repository

import android.content.Context

class PreferencesRepository(val context: Context) {

    companion object {
        private const val KEY_APPLICATION_PREFERENCES = "application_preferences"
        private const val KEY_FIRST_RUN = "first_run"
    }

    var isFirstRun: Boolean
        get() = readBooleanValue(KEY_FIRST_RUN, true)
        set(value) = writeValue(KEY_FIRST_RUN, value)

    private val sharedPref
        get() = context.getSharedPreferences(KEY_APPLICATION_PREFERENCES, Context.MODE_PRIVATE)

    private fun writeValue(key: String, value: String) {
        with(sharedPref.edit()) {
            putString(key, value)
            apply()
        }
    }

    private fun <T> writeValue(key: String, value: T) {
        with(sharedPref.edit()) {
            when (value) {
                is Boolean -> putBoolean(key, value)
                is String -> putString(key, value)
                is Int -> putInt(key, value)
                is Float -> putFloat(key, value)
                is Long -> putLong(key, value)
            }
            apply()
        }
    }

    private fun readString(key: String, defaultValue: String?): String? =
        sharedPref.getString(key, defaultValue)

    private fun readBooleanValue(key: String, defaultValue: Boolean): Boolean =
        sharedPref.getBoolean(key, defaultValue)
}
