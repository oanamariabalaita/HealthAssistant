package com.example.healthassistant.utils.extentions

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

fun Context.showKeyboard(view: View) {
    view.requestFocus()
    val manager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    manager.showSoftInput(view, InputMethodManager.SHOW_FORCED)
}

fun Context.hideKeyboard(currentFocus: View) {
    val manager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    manager.hideSoftInputFromWindow(currentFocus.windowToken, 0)
    currentFocus.clearFocus()
}