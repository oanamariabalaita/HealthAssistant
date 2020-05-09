package com.example.healthassistant.ui.settings

import androidx.fragment.app.viewModels
import com.example.healthassistant.base.BaseViewBindingFragment
import com.example.healthassistant.databinding.SettingsFragmentBinding

class SettingsFragment : BaseViewBindingFragment<SettingsFragmentBinding>() {

    private val profileViewModel: SettingsViewModel by viewModels {
        viewModelFactory
    }

    override fun bind() {
        binding = SettingsFragmentBinding.inflate(layoutInflater)
    }
}
