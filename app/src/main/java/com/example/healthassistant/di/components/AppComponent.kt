package com.example.healthassistant.di.components

import android.app.Application
import com.example.healthassistant.app.App
import com.example.healthassistant.di.modules.AppModule
import com.example.healthassistant.di.modules.CoreDataModule
import com.example.healthassistant.di.modules.FragmentBuildersModule
import com.example.healthassistant.di.modules.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        CoreDataModule::class,
        FragmentBuildersModule::class,
        ViewModelModule::class]
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(application: App)

}