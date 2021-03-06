package com.example.healthassistant.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import javax.inject.Inject

abstract class BaseViewBindingFragment<TViewBinding : ViewBinding> : BaseFragment() {

    private var _viewBinding: TViewBinding? = null
    private val viewBinding get() = _viewBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

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

    override fun onDestroyView() {
        super.onDestroyView()
        _viewBinding = null
    }
}
