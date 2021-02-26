package com.example.healthassistant.presentation.features.statistics

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.healthassistant.databinding.StatisticsFragmentBinding
import com.example.healthassistant.presentation.base.BaseViewBindingFragment

class StatisticsFragment : BaseViewBindingFragment<StatisticsFragmentBinding>() {

    private val statisticsViewModel: StatisticsViewModel by viewModels {
        viewModelFactory
    }

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): StatisticsFragmentBinding =
        StatisticsFragmentBinding.inflate(inflater, container, false)
}
