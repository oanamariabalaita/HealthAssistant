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
) : BaseViewModel() {

    private val _userUiState = MutableStateFlow<UserViewState>(UserViewState.Empty)
    private val _healthIndicesUiState =
        MutableStateFlow<HealthIndicesViewState>(HealthIndicesViewState.Success(emptyList()))
    val healthIndicesViewState: StateFlow<HealthIndicesViewState> = _healthIndicesUiState
    val userViewState: StateFlow<UserViewState> = _userUiState
    private val effectChannel = Channel<DashboardEffect>(Channel.BUFFERED)
    val effectFlow = effectChannel.receiveAsFlow()

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

    private suspend fun loadHealthIndicesFailed(error: Throwable) {
        Timber.e(error)
        sendToastEvent()
        _healthIndicesUiState.emit(HealthIndicesViewState.Error(error))
    }

    private suspend fun loadHealthIndicesSuccess(indices: List<HealthIndex>) {
        indices.let {
            _healthIndicesUiState.emit(HealthIndicesViewState.Success(indices))
        }
    }

    private fun sendToastEvent() {
        viewModelScope.launch {
            effectChannel.send(DashboardEffect.ShowToast("Test:Error but working ok"))
        }
    }
}
