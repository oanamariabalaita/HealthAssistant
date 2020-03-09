package com.example.healthassistant.base.preferences

import android.content.Context
import com.example.healthassistant.app.App

abstract class BasePreferences {

    protected abstract val preferencesName: String

    private val preferences
        get() = App.instance
            .getSharedPreferences(preferencesName, Context.MODE_PRIVATE)

    private val editor
        get() = preferences.edit()

    protected fun getStringEntry(key: String, defaultValue: String) = preferences
        .getString(key, defaultValue) ?: defaultValue

    protected fun setStringEntry(key: String, value: String) = editor
        .putString(key, value)
        .commit()

    protected fun setBooleanEntry(key: String, value: Boolean) = editor
        .putBoolean(key, value)
        .commit()

    protected fun getBooleanEntry(key: String, defaultValue: Boolean = false) = preferences
        .getBoolean(key, defaultValue)
}