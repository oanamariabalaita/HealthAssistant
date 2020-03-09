package com.example.healthassistant.utils.permissions

interface IPermissionsHandler {

        fun getRequestCode(): Int

        fun getPermissions(): Array<String>

        fun onShowPermissionRationale()

        fun onPermissionDenied()

        fun onPermissionGranted()
}