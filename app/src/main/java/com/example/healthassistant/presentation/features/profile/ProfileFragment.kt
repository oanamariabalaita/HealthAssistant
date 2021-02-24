package com.example.healthassistant.presentation.features.profile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.healthassistant.databinding.ProfileFragmentBinding
import com.example.healthassistant.presentation.base.BaseViewBindingFragment

class ProfileFragment : BaseViewBindingFragment<ProfileFragmentBinding>() {

    private val profileViewModel: ProfileViewModel by viewModels {
        viewModelFactory
    }

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): ProfileFragmentBinding =
        ProfileFragmentBinding.inflate(inflater, container, false)
}
