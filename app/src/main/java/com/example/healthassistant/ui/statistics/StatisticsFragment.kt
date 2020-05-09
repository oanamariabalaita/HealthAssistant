package com.example.healthassistant.ui.statistics

import androidx.fragment.app.viewModels
import com.example.healthassistant.base.BaseViewBindingFragment
import com.example.healthassistant.databinding.StatisticsFragmentBinding

class StatisticsFragment : BaseViewBindingFragment<StatisticsFragmentBinding>() {

    private val notificationsViewModel: StatisticsViewModel by viewModels {
        viewModelFactory
    }

    override fun bind() {
        binding = StatisticsFragmentBinding.inflate(layoutInflater)
    }
}
