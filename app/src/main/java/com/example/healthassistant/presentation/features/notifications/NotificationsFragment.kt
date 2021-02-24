package com.example.healthassistant.presentation.features.notifications

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.healthassistant.databinding.NotificationsFragmentBinding
import com.example.healthassistant.presentation.base.BaseViewBindingFragment

class NotificationsFragment : BaseViewBindingFragment<NotificationsFragmentBinding>() {

    private val notificationsViewModel: NotificationsViewModel by viewModels {
        viewModelFactory
    }

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): NotificationsFragmentBinding =
        NotificationsFragmentBinding.inflate(inflater, container, false)
}
