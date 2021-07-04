package com.example.healthassistant.presentation.features.dashboard

import androidx.lifecycle.viewModelScope
import com.example.healthassistant.domain.interactor.GetHealthIndicesUseCase
import com.example.healthassistant.domain.interactor.GetHealthSummaryUseCase
import com.example.healthassistant.domain.interactor.GetUserUseCase
import com.example.healthassistant.domain.model.HealthIndex
import com.example.healthassistant.domain.model.HealthSummary
import com.example.healthassistant.presentation.base.BaseViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber

class DashboardViewModel(
    private val healthIndicesUseCase: GetHealthIndicesUseCase,
    private val healthSummaryUseCase: GetHealthSummaryUseCase,
    private val userUseCase: GetUserUseCase
) : BaseViewModel(), DashboardEvent {

    private val _state = MutableStateFlow(DashboardState())
    private val _effect = MutableSharedFlow<DashboardEffect>()

    val state = _state.asStateFlow()
    val effect = _effect.asSharedFlow()
    val event = this as DashboardEvent

    init {
        loadHealthSummary("982")
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

    private fun loadHealthSummary(userId: String) {
        viewModelScope.launch {
            healthSummaryUseCase
                .run(GetHealthSummaryUseCase.Params(userId))
                .execute(
                    success = ::loadHealthSummarySuccess,
                    error = ::loadHealthSummaryFailed,
                    before = { _state.update(summaryLoading = true) },
                    after = { _state.update(summaryLoading = false) }
                )
        }
    }

    private suspend fun loadHealthIndicesFailed(error: Throwable) {
        Timber.e(error)
        _effect.emit(DashboardEffect.ShowToast("Test: Health Indices List Error"))
    }

    private suspend fun loadHealthIndicesSuccess(indices: List<HealthIndex>) {
        _state.update(indices = indices)
    }

    private suspend fun loadHealthSummaryFailed(error: Throwable) {
        Timber.e(error)
        _effect.emit(DashboardEffect.ShowToast("Test: HealthSummary Error"))
    }

    private suspend fun loadHealthSummarySuccess(healthSummary: HealthSummary) {
        _state.update(healthSummaryScore = healthSummary.healthIndexScore)
    }

    override fun onCardDetailsClick(cardId: Long) {}

    override fun onHealthSummaryClick() {}

    override fun onStatisticsClick() {}

    override fun onRefreshSwipe() {}
}
