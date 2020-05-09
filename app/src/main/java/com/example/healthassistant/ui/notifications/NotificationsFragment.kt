package com.example.healthassistant.ui.notifications

import androidx.fragment.app.viewModels
import com.example.healthassistant.base.BaseViewBindingFragment
import com.example.healthassistant.databinding.NotificationsFragmentBinding

class NotificationsFragment : BaseViewBindingFragment<NotificationsFragmentBinding>() {

    private val notificationsViewModel: NotificationsViewModel by viewModels {
        viewModelFactory
    }

    override fun bind() {
        binding = NotificationsFragmentBinding.inflate(layoutInflater)
    }
}
