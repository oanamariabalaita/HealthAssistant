package com.example.healthassistant.di.modules

import com.example.healthassistant.data.remote.HealthIndicatorRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
abstract class AppModule {

    @Singleton
    @Binds
    abstract fun bindRepository(repo: HealthIndicatorRepository): HealthIndicatorRepository
}
