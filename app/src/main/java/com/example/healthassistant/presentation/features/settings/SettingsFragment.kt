package com.example.healthassistant.presentation.features.settings

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.healthassistant.databinding.SettingsFragmentBinding
import com.example.healthassistant.presentation.base.BaseViewBindingFragment

class SettingsFragment : BaseViewBindingFragment<SettingsFragmentBinding>() {

    private val settingsViewModel: SettingsViewModel by viewModels {
        viewModelFactory
    }

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): SettingsFragmentBinding =
        SettingsFragmentBinding.inflate(inflater, container, false)
}
