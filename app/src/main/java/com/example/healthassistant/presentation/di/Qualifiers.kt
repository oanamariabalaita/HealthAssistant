package com.example.healthassistant.presentation.di

import javax.inject.Qualifier
import javax.inject.Scope

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class CoroutineScopeIO

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityScope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerFragment
