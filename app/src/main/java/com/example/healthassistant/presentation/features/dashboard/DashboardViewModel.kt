package com.example.healthassistant.presentation.features.dashboard

import androidx.lifecycle.viewModelScope
import com.example.healthassistant.domain.interactor.GetHealthIndicesUseCase
import com.example.healthassistant.domain.interactor.GetUserUseCase
import com.example.healthassistant.domain.model.HealthIndex
import com.example.healthassistant.domain.model.User
import com.example.healthassistant.domain.repository.PreferencesRepository
import com.example.healthassistant.presentation.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

class DashboardViewModel @Inject constructor(
    private val preferencesRepository: PreferencesRepository,
    private val healthIndicesUseCase: GetHealthIndicesUseCase,
    private val userUseCase: GetUserUseCase
) : BaseViewModel() {

    private val _userUiState = MutableStateFlow(UserViewState.Empty)
    private val _healthIndicesUiState =
        MutableStateFlow<HealthIndicesViewState>(HealthIndicesViewState.Success(emptyList()))
    val healthIndicesViewState: StateFlow<HealthIndicesViewState>
        get() = _healthIndicesUiState
    val userViewState: StateFlow<UserViewState>
        get() = _userUiState

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

    private fun loadHealthIndicesFailed(error: Throwable) {
        Timber.e(error)
        _healthIndicesUiState.value = HealthIndicesViewState.Error(error)
    }

    private fun loadHealthIndicesSuccess(indices: List<HealthIndex>) {
        indices.let {
            _healthIndicesUiState.value = HealthIndicesViewState.Success(indices)
        }
    }
}

sealed class HealthIndicesViewState {
    data class Success(val indices: List<HealthIndex>) : HealthIndicesViewState()
    data class Error(val exception: Throwable) : HealthIndicesViewState()
}

sealed class UserViewState {
    data class Success(val user: User) : UserViewState()
    data class Error(val exception: Throwable) : UserViewState()
    object Empty : UserViewState()
}

sealed class AppViewEffect {
    data class ShowToast(val message: String) : AppViewEffect()
}
