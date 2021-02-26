package com.example.healthassistant.presentation.features.dashboard

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.healthassistant.databinding.DashboardFragmentBinding
import com.example.healthassistant.presentation.base.BaseViewBindingFragment
import dagger.android.support.AndroidSupportInjection
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect

class DashboardFragment : BaseViewBindingFragment<DashboardFragmentBinding>() {

    private val dashboardViewModel: DashboardViewModel by viewModels {
        viewModelFactory
    }
    private var userViewStateJob: Job? = null
    private var indicesStateJob: Job? = null

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): DashboardFragmentBinding =
        DashboardFragmentBinding.inflate(inflater, container, false)

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onStart() {
        super.onStart()

        dashboardViewModel.apply {
            userViewStateJob = lifecycleScope.launchWhenStarted {
                userViewState.collect { state ->
                    handleUserViewState(state)
                }
            }
            indicesStateJob = lifecycleScope.launchWhenStarted {
                healthIndicesViewState.collect { state ->
                    handleIndicesViewState(state)
                }
            }
        }
    }

    override fun onStop() {
        userViewStateJob?.cancel()
        indicesStateJob?.cancel()
        super.onStop()
    }

    private fun handleUserViewState(state: UserViewState) {
        when (state) {
            is UserViewState.Success -> {
            }
            is UserViewState.Error -> {
            }
            is UserViewState.Empty -> {
            }
        }
    }

    private fun handleIndicesViewState(state: HealthIndicesViewState) {
        when (state) {
            is HealthIndicesViewState.Success -> {
            }
            is HealthIndicesViewState.Error -> {
            }
        }
    }
}
