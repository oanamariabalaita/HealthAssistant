package com.example.healthassistant.domain.di

import android.content.Context
import com.example.healthassistant.data.api.HealthApiService
import com.example.healthassistant.data.api.UserApiService
import com.example.healthassistant.data.db.HealthDao
import com.example.healthassistant.data.db.UserDao
import com.example.healthassistant.domain.interactor.GetHealthIndicesUseCase
import com.example.healthassistant.domain.interactor.GetUserUseCase
import com.example.healthassistant.domain.repository.HealthRepository
import com.example.healthassistant.domain.repository.PreferencesRepository
import com.example.healthassistant.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class InteractionModule {

    @Provides
    fun providesIGetUserUseCase(userRepository: UserRepository): GetUserUseCase =
        GetUserUseCase(userRepository)

    @Provides
    fun providesIHealthIndicatorUseCase(healthRepository: HealthRepository) =
        GetHealthIndicesUseCase(healthRepository)

    @Provides
    fun providesHealthRepository(
        healthDao: HealthDao,
        healthService: HealthApiService
    ): HealthRepository = HealthRepository(healthDao, healthService)

    @Provides
    fun providesUserRepository(
        userDao: UserDao,
        userService: UserApiService
    ): UserRepository = UserRepository(userDao, userService)

    @Singleton
    @Provides
    fun providesPreferencesRepository(context: Context): PreferencesRepository =
        PreferencesRepository(context)
}
