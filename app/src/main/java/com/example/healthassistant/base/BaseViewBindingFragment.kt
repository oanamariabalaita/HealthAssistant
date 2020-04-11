package com.example.healthassistant.base

import androidx.lifecycle.LifecycleOwner
import androidx.viewbinding.ViewBinding
import com.example.healthassistant.utils.navigation.INavigationResult
import com.example.healthassistant.utils.navigation.NavigationResult
import com.example.healthassistant.utils.navigation.NavigationResultViewModel
import com.example.healthassistant.utils.permissions.FragmentPermissionsHandler
import com.example.healthassistant.utils.permissions.IFragmentPermissions
import com.example.healthassistant.utils.permissions.IPermissionsHandler
import com.github.mustafaozhan.basemob.fragment.BaseVBFragment
import javax.inject.Inject

abstract class BaseViewBindingFragment<TViewBinding : ViewBinding> : BaseVBFragment<TViewBinding>(),
    IFragmentPermissions, INavigationResult {

    @Inject
    lateinit var navigationResultViewModel: NavigationResultViewModel

    @Inject
    lateinit var fragmentPermissionHandler: FragmentPermissionsHandler

    open fun canNavigateUp() = true

    open fun onBackPressed() {}


    override fun runWithPermission(permissionsHandler: IPermissionsHandler) {
        fragmentPermissionHandler.runWithPermission(permissionsHandler, this)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        fragmentPermissionHandler.handleRequestPermissionResult(
            requestCode,
            permissions,
            grantResults
        )
    }

    override fun observeNavigationResult(
        tag: String,
        lifecycleOwner: LifecycleOwner,
        callback: (navigationResult: NavigationResult) -> Unit
    ) {
        navigationResultViewModel.observeNavigationResult(tag, lifecycleOwner, callback)
    }

    override fun setNavigationResult(tag: String, navigationResult: NavigationResult) {
        navigationResultViewModel.produceNavigationResult(tag, navigationResult)
    }

}