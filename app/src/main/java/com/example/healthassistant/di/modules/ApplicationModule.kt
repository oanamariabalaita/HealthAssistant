package com.example.healthassistant.di.modules

//
//import com.example.healthassistant.BuildConfig
//import com.example.healthassistant.data.HealthService
//import com.example.healthassistant.utils.constants.Constants
//import com.example.healthassistant.utils.navigation.NavigationResultViewModel
//import com.example.healthassistant.utils.permissions.FragmentPermissionsHandler
//import com.facebook.stetho.okhttp3.StethoInterceptor
//import com.google.gson.Gson
//import dagger.Module
//import dagger.Provides
//import okhttp3.OkHttpClient
//import okhttp3.logging.HttpLoggingInterceptor
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//import javax.inject.Qualifier
//import javax.inject.Singleton
//
//@Module
//class ApplicationModule {
//
//    @Provides
//    fun provideOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient =
//        OkHttpClient.Builder().addInterceptor(interceptor)
//            .addNetworkInterceptor(StethoInterceptor())
//            .build()
//
//    @Provides
//    fun provideLoggingInterceptor() =
//        HttpLoggingInterceptor().apply { level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE }
//
//    @Provides
//    @Singleton
//    fun provideGson(): Gson = Gson()
//
//    @Provides
//    @Singleton
//    fun provideGsonConverterFactory(gson: Gson): GsonConverterFactory =
//        GsonConverterFactory.create(gson)
//
//    @Provides
//    @Singleton
//    fun provideNavigationResultViewModel(): NavigationResultViewModel = NavigationResultViewModel()
//
//    @Provides
//    @Singleton
//    fun provideFragmentPermissionHandler(): FragmentPermissionsHandler =
//        FragmentPermissionsHandler()
//
////    @CoroutineScropeIO
////    @Provides
////    fun provideCoroutineScopeIO() = CoroutineScope(Dispatchers.IO)
//
//    private fun createRetrofit(
//        okhttpClient: OkHttpClient
//    ): Retrofit {
//        return Retrofit.Builder()
//            .baseUrl(Constants.ENDPOINT)
//            .client(okhttpClient)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }
//
//    private fun <T> provideService(
//        okhttpClient: OkHttpClient,
//        clazz: Class<T>
//    ): T {
//        return createRetrofit(okhttpClient).create(clazz)
//    }
//
////    @Singleton
////    @Provides
////    fun provideHealthService(): HealthService {
////        return provideService()
////    }
//
//    @Qualifier
//    @Retention(AnnotationRetention.RUNTIME)
//    annotation class HealthRemoteDataSource
//
//    @Qualifier
//    @Retention(AnnotationRetention.RUNTIME)
//    annotation class HealthLocalDataSource
//
//}

