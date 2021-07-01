package com.example.healthassistant.presentation.features.dashboard

import androidx.lifecycle.viewModelScope
import com.example.healthassistant.domain.interactor.GetHealthIndicesUseCase
import com.example.healthassistant.domain.interactor.GetUserUseCase
import com.example.healthassistant.domain.model.HealthIndex
import com.example.healthassistant.presentation.base.BaseViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber

class DashboardViewModel(
    private val healthIndicesUseCase: GetHealthIndicesUseCase,
    private val userUseCase: GetUserUseCase
) : BaseViewModel(), DashboardEvent {

    private val _state = MutableStateFlow(DashboardState())
    private val _effect = MutableSharedFlow<DashboardEffect>()

    val state = _state.asStateFlow()
    val effect = _effect.asSharedFlow()
    val event = this as DashboardEvent

    init {
        loadHealthIndicesList("982")
    }

    private fun loadHealthIndicesList(userId: String) {
        viewModelScope.launch {
            healthIndicesUseCase
                .run(GetHealthIndicesUseCase.Params(userId))
                .execute(
                    success = ::loadHealthIndicesSuccess,
                    error = ::loadHealthIndicesFailed,
                    before = { _state.update(healthIndicesLoading = true) },
                    after = { _state.update(healthIndicesLoading = false) }
                )
        }
    }

    private suspend fun loadHealthIndicesFailed(error: Throwable) {
        Timber.e(error)
        _effect.emit(DashboardEffect.ShowToast("Test:ERROR but working ok"))
    }

    private suspend fun loadHealthIndicesSuccess(indices: List<HealthIndex>) {
        _effect.emit(DashboardEffect.ShowToast("Test:SUCCESS and working ok"))
        _state.update(indices = indices)
    }

    override fun onCardDetailsClick(cardId: Long) {}

    override fun onHealthSummaryClick() {}

    override fun onStatisticsClick() {}

    override fun onRefreshSwipe() {}
}
