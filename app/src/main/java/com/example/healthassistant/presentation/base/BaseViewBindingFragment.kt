package com.example.healthassistant.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.example.healthassistant.presentation.utils.navigation.INavigationResult
import com.example.healthassistant.presentation.utils.navigation.NavigationResult
import com.example.healthassistant.presentation.utils.navigation.NavigationResultViewModel
import javax.inject.Inject

abstract class BaseViewBindingFragment<TViewBinding : ViewBinding> : BaseFragment(),
    INavigationResult {

    private var _viewBinding: TViewBinding? = null
    private val viewBinding get() = _viewBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val navigationResultViewModel: NavigationResultViewModel by viewModels {
        viewModelFactory
    }

    open fun canNavigateUp() = true

    open fun onBackPressed() {}

    abstract fun createBinding(inflater: LayoutInflater, container: ViewGroup?): TViewBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = createBinding(inflater, container).also {
        _viewBinding = it
    }.root

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

    override fun onDestroyView() {
        super.onDestroyView()
        _viewBinding = null
    }
}
