package com.example.healthassistant.data.di

import com.example.healthassistant.data.api.HealthApiService
import com.example.healthassistant.data.api.UserApiService
import com.example.healthassistant.data.utils.OkHttpFactory
import com.example.healthassistant.data.utils.RetrofitFactory
import com.example.healthassistant.data.utils.interceptors.HeaderInterceptor
import kotlinx.serialization.ExperimentalSerializationApi
import org.koin.dsl.module
import retrofit2.Retrofit

@ExperimentalSerializationApi
val networkModule = module {

    single { HeaderInterceptor() }
    single { RetrofitFactory.createRetrofit(get()) }
    single {
        OkHttpFactory.createDebugOkHttpClient(
            setOf(get<HeaderInterceptor>())
        )
    }
    single { get<Retrofit>().create(HealthApiService::class.java) }
    single { get<Retrofit>().create(UserApiService::class.java) }
}
