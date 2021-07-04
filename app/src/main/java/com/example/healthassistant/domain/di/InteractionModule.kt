package com.example.healthassistant.domain.di

import com.example.healthassistant.domain.interactor.GetHealthIndicesUseCase
import com.example.healthassistant.domain.interactor.GetHealthSummaryUseCase
import com.example.healthassistant.domain.interactor.GetUserUseCase
import com.example.healthassistant.domain.repository.HealthRepository
import com.example.healthassistant.domain.repository.PreferencesRepository
import com.example.healthassistant.domain.repository.UserRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val interactionModule = module {

    single { UserRepository(get(), get()) }
    single { HealthRepository(get(), get()) }
    single { PreferencesRepository(get()) }
    single { GetUserUseCase(get()) }
    single { GetHealthIndicesUseCase(androidContext(), get()) }
    single { GetHealthSummaryUseCase(get()) }
}
