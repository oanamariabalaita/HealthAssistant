package com.example.healthassistant.utils.permissions

import android.content.pm.PackageManager
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

class FragmentPermissionsHandler {

    private val permissionHandlerMap = mutableMapOf<Int, IPermissionsHandler>()

    fun runWithPermission(permissionHandler: IPermissionsHandler, fragment: Fragment) {
        var hasPermissions = true

        permissionHandler.getPermissions().forEach { p ->
            val granted = ContextCompat.checkSelfPermission(
                fragment.context!!,
                p
            ) == PackageManager.PERMISSION_GRANTED
            hasPermissions = hasPermissions.and(granted)
        }

        if (hasPermissions) {
            permissionHandlerMap.remove(permissionHandler.getRequestCode())
            permissionHandler.onPermissionGranted()
        } else {
            var shouldShowRationale = true

            permissionHandler.getPermissions().forEach { p ->
                val showRationale = fragment.shouldShowRequestPermissionRationale(p)
                shouldShowRationale = shouldShowRationale.and(showRationale)
            }

            if (shouldShowRationale) {
                permissionHandler.onShowPermissionRationale()
            }

            permissionHandlerMap[permissionHandler.getRequestCode()] = permissionHandler
            fragment.requestPermissions(
                permissionHandler.getPermissions(),
                permissionHandler.getRequestCode()
            )
        }
    }

    fun handleRequestPermissionResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (!permissionHandlerMap.containsKey(requestCode)) {
            throw IllegalStateException("Permissions should be handled via runWithPermission function")
        }

        val permissionHandler = permissionHandlerMap[requestCode]!!

        if (grantResults.isEmpty() || grantResults.contains(PackageManager.PERMISSION_DENIED)) {
            permissionHandler.onPermissionDenied()
        } else {
            permissionHandler.onPermissionGranted()
        }
    }
}