package com.example.healthassistant.utils.extentions

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.DialogFragmentNavigator
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.findNavController

fun Fragment.isCurrentDestination(): Boolean {
    val currentDestinationClassName =
        when (val currDest = findNavController().currentDestination ?: return false) {
            is FragmentNavigator.Destination -> currDest.className
            is DialogFragmentNavigator.Destination -> currDest.className
            else -> return false
        }

    return currentDestinationClassName == javaClass.name ||
            currentDestinationClassName == parentFragment?.javaClass?.name
}