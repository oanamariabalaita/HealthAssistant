package com.example.healthassistant.ui.dashboard

import androidx.lifecycle.MutableLiveData
import com.github.mustafaozhan.basemob.view.BaseViewState


data class DashboardViewState(
    val noResult: MutableLiveData<Boolean> = MutableLiveData(false)
) : BaseViewState()