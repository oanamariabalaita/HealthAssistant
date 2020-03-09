package com.example.healthassistant.utils

import android.graphics.Rect
import android.view.View

fun isKeyboardShown(rootView: View): Boolean {
    val softKeyboardHeight = 100 // NOTE: should be minimum keyboard height
    val r = Rect()
    rootView.getWindowVisibleDisplayFrame(r)
    val dm = rootView.resources.displayMetrics
    val heightDiff = rootView.bottom - r.bottom
    return heightDiff > softKeyboardHeight * dm.density
}