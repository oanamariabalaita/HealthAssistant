package com.example.healthassistant.data.api

import com.example.healthassistant.utils.constants.Constants.BASE_URL
import com.google.gson.Gson
import okhttp3.ConnectionSpec
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitFactory {

    fun createRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    fun makeClient(vararg interceptors: Interceptor): OkHttpClient {
        val builder = OkHttpClient().newBuilder()
            .connectionSpecs(listOf(ConnectionSpec.CLEARTEXT, ConnectionSpec.COMPATIBLE_TLS))
//            .readTimeout(BuildConfig.READ_TIMEOUT, TimeUnit.MILLISECONDS)
//            .connectTimeout(BuildConfig.CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
//            .addInterceptor(makeLoggingInterceptor())

        for (interceptor in interceptors) {
            builder.addInterceptor(interceptor)
        }

        return builder.build()
    }
}
