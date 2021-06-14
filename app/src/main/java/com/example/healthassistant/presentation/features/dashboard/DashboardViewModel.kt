package com.example.healthassistant.presentation.features.dashboard

import androidx.lifecycle.viewModelScope
import com.example.healthassistant.domain.interactor.GetHealthIndicesUseCase
import com.example.healthassistant.domain.interactor.GetUserUseCase
import com.example.healthassistant.domain.model.HealthIndex
import com.example.healthassistant.presentation.base.BaseViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import timber.log.Timber

class DashboardViewModel(
    private val healthIndicesUseCase: GetHealthIndicesUseCase,
    private val userUseCase: GetUserUseCase
) : BaseViewModel(), DashboardEvent {

    private val _userUiState = MutableStateFlow<UserViewState>(UserViewState.Empty)
    private val _healthIndicesUiState =
        MutableStateFlow<HealthIndicesViewState>(HealthIndicesViewState.Success(emptyList()))
    private val _healthSummaryState = MutableStateFlow<HealthSummaryState>(HealthSummaryState.Empty)
    val healthIndicesViewState: StateFlow<HealthIndicesViewState> = _healthIndicesUiState
    val userViewState: StateFlow<UserViewState> = _userUiState
    val healthSummaryState: StateFlow<HealthSummaryState> = _healthSummaryState
    private val effectChannel = Channel<DashboardEffect>(Channel.BUFFERED)
    val effectFlow = effectChannel.receiveAsFlow()
    val event = this as DashboardEvent

    init {
        loadHealthIndicesList("982")
    }

    private fun loadHealthIndicesList(userId: String) {
        viewModelScope.launch {
            healthIndicesUseCase
                .run(GetHealthIndicesUseCase.Params(userId))
                .execute(
                    ::loadHealthIndicesSuccess,
                    ::loadHealthIndicesFailed
                )
        }
    }

    // region State
    private suspend fun loadHealthIndicesFailed(error: Throwable) {
        Timber.e(error)
        effectChannel.send(DashboardEffect.ShowToast("Test:ERROR but working ok"))
        _healthIndicesUiState.emit(HealthIndicesViewState.Error(error))
    }

    private suspend fun loadHealthIndicesSuccess(indices: List<HealthIndex>) {
        effectChannel.send(DashboardEffect.ShowToast("Test:SUCCESS and working ok"))
        indices.let {
            _healthIndicesUiState.emit(HealthIndicesViewState.Success(indices))
        }
    }

    // endregion

    // region Event

    override fun onCardDetailsClick(cardId: Long) {
    }

    override fun onHealthSummaryClick() {
    }

    override fun onStatisticsClick() {
    }

    override fun onRefreshSwipe() {

    }

    // endregion

}
