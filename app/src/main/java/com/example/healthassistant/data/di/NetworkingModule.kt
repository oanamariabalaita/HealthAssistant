package com.example.healthassistant.data.di

import com.example.healthassistant.data.api.HealthApiService
import com.example.healthassistant.data.api.UserApiService
import com.example.healthassistant.data.utils.OkHttpFactory
import com.example.healthassistant.data.utils.RetrofitFactory
import com.example.healthassistant.data.utils.interceptors.HeaderInterceptor
import dagger.Module
import dagger.Provides
import kotlinx.serialization.ExperimentalSerializationApi
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
class NetworkingModule {

    @Provides
    @ExperimentalSerializationApi
    fun provideHealthApiService(okHttpClient: OkHttpClient): HealthApiService =
        RetrofitFactory
            .createRetrofit(okHttpClient)
            .create(HealthApiService::class.java)

    @Provides
    @ExperimentalSerializationApi
    fun provideUserApiService(okHttpClient: OkHttpClient): UserApiService =
        RetrofitFactory
            .createRetrofit(okHttpClient)
            .create(UserApiService::class.java)

    @Singleton
    @Provides
    fun providesOkHttpClient(headerInterceptor: HeaderInterceptor): OkHttpClient =
        OkHttpFactory.createDebugOkHttpClient(setOf(headerInterceptor))

    @Provides
    @Singleton
    fun providesHeaderInterceptor(): HeaderInterceptor = HeaderInterceptor()

}
