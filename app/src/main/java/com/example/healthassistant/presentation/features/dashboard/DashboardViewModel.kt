package com.example.healthassistant.presentation.features.dashboard

import androidx.lifecycle.viewModelScope
import com.example.healthassistant.domain.interactor.GetHealthIndicesUseCase
import com.example.healthassistant.domain.interactor.GetUserUseCase
import com.example.healthassistant.domain.model.HealthIndex
import com.example.healthassistant.domain.repository.PreferencesRepository
import com.example.healthassistant.presentation.base.BaseViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

class DashboardViewModel @Inject constructor(
    private val preferencesRepository: PreferencesRepository,
    private val healthIndicesUseCase: GetHealthIndicesUseCase,
    private val userUseCase: GetUserUseCase
) : BaseViewModel(), DashboardEvent {

    private val _userUiState = MutableStateFlow<UserViewState>(UserViewState.Empty)
    private val _healthIndicesUiState =
        MutableStateFlow<HealthIndicesViewState>(HealthIndicesViewState.Success(emptyList()))
    val healthIndicesViewState: StateFlow<HealthIndicesViewState> = _healthIndicesUiState
    val userViewState: StateFlow<UserViewState> = _userUiState
    private val effectChannel = Channel<DashboardEffect>(Channel.BUFFERED)
    val effectFlow = effectChannel.receiveAsFlow()
    val event = this as DashboardEvent

    init {
        loadHealthIndicesList("test1928878")
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
        sendToastEffect()
        _healthIndicesUiState.emit(HealthIndicesViewState.Error(error))
    }

    private suspend fun loadHealthIndicesSuccess(indices: List<HealthIndex>) {
        indices.let {
            _healthIndicesUiState.emit(HealthIndicesViewState.Success(indices))
        }
    }

    // endregion

    // region Effect

    private fun sendToastEffect() {
        viewModelScope.launch {
            effectChannel.send(DashboardEffect.ShowToast("Test:Error but working ok"))
        }
    }

    // endregion

    // region Event

    override fun onCardDetailsClick(userId: Long, cardId: Long) {
        // "Not yet implemented"
    }

    override fun onStatisticsClick() {
        // "Not yet implemented"
    }

    override fun onRefreshSwipe() {
        // "Not yet implemented"
    }

    // endregion

}
