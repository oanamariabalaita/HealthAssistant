package com.example.healthassistant.presentation.base

import androidx.databinding.ViewDataBinding
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import com.example.healthassistant.presentation.utils.navigation.INavigationResult
import com.example.healthassistant.presentation.utils.navigation.NavigationResult
import com.example.healthassistant.presentation.utils.navigation.NavigationResultViewModel
import javax.inject.Inject

abstract class BaseDataBindingFragment<TDataBinding : ViewDataBinding> : BaseFragment(),
    INavigationResult {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val navigationResultViewModel: NavigationResultViewModel by viewModels {
        viewModelFactory
    }

    open fun canNavigateUp() = true

    open fun onBackPressed() {}

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
