package com.example.healthassistant.presentation

import com.example.healthassistant.domain.repository.PreferencesRepository
import com.example.healthassistant.presentation.base.BaseViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor(
    val preferencesRepository: PreferencesRepository
) : BaseViewModel()
