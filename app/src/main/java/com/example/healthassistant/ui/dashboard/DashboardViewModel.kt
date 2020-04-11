package com.example.healthassistant.ui.dashboard

import androidx.lifecycle.MutableLiveData
import com.github.mustafaozhan.basemob.view.BaseViewEffect
import com.github.mustafaozhan.basemob.view.BaseViewEvent
import com.github.mustafaozhan.basemob.view.BaseViewState
import com.github.mustafaozhan.basemob.viewmodel.UDFViewModel
import javax.inject.Inject

class DashboardViewModel<ViewEffect : BaseViewEffect, ViewEvent : BaseViewEvent, ViewState : BaseViewState> @Inject constructor() :
    UDFViewModel<DashboardViewEffect, DashboardViewEvent, DashboardViewState>(),
    DashboardViewEvent {

    override val viewEffectLiveData: MutableLiveData<DashboardViewEffect>
        get() = MutableLiveData()

    override val viewState: DashboardViewState
        get() = DashboardViewState()

    override fun getViewEvent() = this as DashboardViewEvent

}
