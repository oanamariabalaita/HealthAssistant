package com.example.healthassistant.di.modules

import com.example.healthassistant.BuildConfig
import com.example.healthassistant.utils.navigation.NavigationResultViewModel
import com.example.healthassistant.utils.networkhandler.FragmentNetworkErrorHandler
import com.example.healthassistant.utils.networkhandler.IFragmentNetworkErrorHandler
import com.example.healthassistant.utils.networkhandler.INetworkErrorHandler
import com.example.healthassistant.utils.permissions.FragmentPermissionsHandler
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.internal.platform.Platform
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BODY
import okhttp3.logging.HttpLoggingInterceptor.Level.NONE
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class CoreDataModule {

    @Provides
    fun provideOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder().addInterceptor(interceptor)
            .addNetworkInterceptor(StethoInterceptor())
            .build()

    @Provides
    fun provideLoggingInterceptor() =
        HttpLoggingInterceptor().apply { level = if (BuildConfig.DEBUG) BODY else NONE }

    @Provides
    @Singleton
    fun provideGson(): Gson = Gson()

    @Provides
    @Singleton
    fun provideGsonConverterFactory(gson: Gson): GsonConverterFactory =
        GsonConverterFactory.create(gson)

    @Provides
    @Singleton
    fun provideNavigationResultViewModel(): NavigationResultViewModel = NavigationResultViewModel()

    @Provides
    @Singleton
    fun provideFragmentPermissionHandler(): FragmentPermissionsHandler =
        FragmentPermissionsHandler()

    @Provides
    @Singleton
    fun provideIFragmentErrorHandler(): FragmentNetworkErrorHandler = FragmentNetworkErrorHandler()

}