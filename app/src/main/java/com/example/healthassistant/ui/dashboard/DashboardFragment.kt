package com.example.healthassistant.ui.dashboard

import android.content.Context
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.healthassistant.base.BaseDataBindingFragment
import com.example.healthassistant.databinding.DashboardFragmentBinding
import com.example.healthassistant.utils.ApplicationExecutors
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class DashboardFragment : BaseDataBindingFragment<DashboardFragmentBinding>() {

    @Inject
    lateinit var appExecutors: ApplicationExecutors

    private val dashboardViewModel: DashboardViewModel by viewModels {
        viewModelFactory
    }

    override fun bind(container: ViewGroup?): DashboardFragmentBinding =
        DashboardFragmentBinding.inflate(layoutInflater, container, false)

    override fun onBinding(dataBinding: DashboardFragmentBinding) {
        binding.vm = dashboardViewModel
        dashboardViewModel.getEvent().let {
            binding.event = it
        }
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }
}
