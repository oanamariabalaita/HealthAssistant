package com.example.healthassistant.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import com.example.healthassistant.R
import com.example.healthassistant.utils.extentions.isCurrentDestination
import com.example.healthassistant.utils.navigation.NavigationResult
import com.example.healthassistant.utils.navigation.NavigationResultViewModel
import com.example.healthassistant.utils.navigation.ToolbarNavigationHandler
import com.example.healthassistant.utils.networkhandler.FragmentNetworkErrorHandler
import com.example.healthassistant.utils.permissions.FragmentPermissionsHandler
import com.example.healthassistant.utils.permissions.IPermissionsHandler
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

abstract class BaseFragment : Fragment() {

    @Inject
    lateinit var networkErrorHandler: FragmentNetworkErrorHandler

    @Inject
    lateinit var navigationResultViewModel: NavigationResultViewModel

    @Inject
    lateinit var fragmentPermissionHandler: FragmentPermissionsHandler

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            onBackPressed()

            if (canNavigateUp()) {
                isEnabled = false
                requireActivity().onBackPressedDispatcher.onBackPressed()
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setupToolbar()
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        networkErrorHandler.setFragment(this)
    }

    private fun getBaseActivity() = activity as? BaseActivity<*>

    private fun setupToolbar() {
        getToolbar()?.let { toolbar ->
            setHasOptionsMenu(true)
            val compatActivity: AppCompatActivity = activity as AppCompatActivity
            compatActivity.setSupportActionBar(toolbar)
            ToolbarNavigationHandler(
                toolbar,
                findNavController(),
                setOf(R.id.dashboardFragment)
            )
        }
    }

    fun navigateUp() {
        findNavController().navigateUp()
    }

    open fun getToolbar(): Toolbar? = null

    open fun canNavigateUp() = true

    open fun onBackPressed() {}

    open fun onKeyboardShow() {}

    open fun onKeyboardHide() {}

    fun navigate(navDirections: NavDirections) {
        if (isCurrentDestination()) {
            findNavController().navigate(navDirections)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home && !canNavigateUp()) {
            return true
        }

        return item.onNavDestinationSelected(findNavController()) || super.onOptionsItemSelected(
            item
        )
    }
//
//    override fun runWithPermission(permissionHandler: IPermissionsHandler) {
//        fragmentPermissionHandler.runWithPermission(permissionHandler, this)
//    }

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

//    override fun observeNavigationResult(
//        tag: String,
//        lifecycleOwner: LifecycleOwner,
//        callback: (navigationResult: NavigationResult) -> Unit
//    ) {
//        navigationResultViewModel.observeNavigationResult(tag, lifecycleOwner, callback)
//    }

//    override fun setNavigationResult(tag: String, navigationResult: NavigationResult) {
//        navigationResultViewModel.produceNavigationResult(tag, navigationResult)
//    }

}