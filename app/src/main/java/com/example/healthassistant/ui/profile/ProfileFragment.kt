package com.example.healthassistant.ui.profile

import androidx.fragment.app.viewModels
import com.example.healthassistant.base.BaseViewBindingFragment
import com.example.healthassistant.databinding.ProfileFragmentBinding

class ProfileFragment : BaseViewBindingFragment<ProfileFragmentBinding>() {

    private val profileViewModel: ProfileViewModel by viewModels {
        viewModelFactory
    }

    override fun bind() {
        binding = ProfileFragmentBinding.inflate(layoutInflater)
    }
}
