package com.example.healthassistant.ui.dashboard

import com.example.healthassistant.ui.dashboard.structure.DashboardData
import com.example.healthassistant.ui.dashboard.structure.DashboardEffect
import com.example.healthassistant.ui.dashboard.structure.DashboardEvent
import com.example.healthassistant.ui.dashboard.structure.DashboardState
import com.github.mustafaozhan.basemob.lifecycle.MutableSingleLiveData
import com.github.mustafaozhan.basemob.lifecycle.SingleLiveData
import com.github.mustafaozhan.basemob.viewmodel.SEEDViewModel
import javax.inject.Inject

class DashboardViewModel @Inject constructor() :
    SEEDViewModel<DashboardState, DashboardEvent, DashboardEffect, DashboardData>(),
    DashboardEvent {

    // region SEED
    override val state: DashboardState
        get() = DashboardState()

    private val _effect = MutableSingleLiveData<DashboardEffect>()
    override val effect: SingleLiveData<DashboardEffect>
        get() = _effect

    override val data: DashboardData
        get() = DashboardData()

    override fun getEvent() = this as DashboardEvent
    // endregion

    // region Event

    // endregion
}
