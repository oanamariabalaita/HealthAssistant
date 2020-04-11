package com.example.healthassistant.ui.dashboard

import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.healthassistant.base.BaseDataBindingFragment
import com.example.healthassistant.databinding.DashboardFragmentBinding
import com.example.healthassistant.utils.ApplicationExecutors
import javax.inject.Inject

class DashboardFragment : BaseDataBindingFragment<DashboardFragmentBinding>() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var appExecutors: ApplicationExecutors

    private val dashboardViewModel: DashboardViewModel by viewModels {
        viewModelFactory
    }

    private lateinit var dashboardViewEvent: DashboardViewEvent

    override fun bind(container: ViewGroup?): DashboardFragmentBinding =
        DashboardFragmentBinding.inflate(layoutInflater, container, false)

    override fun onBinding(dataBinding: DashboardFragmentBinding) {
        binding.viewModel = dashboardViewModel
//        binding.viewEvent = dashboardViewEvent
    }

}
