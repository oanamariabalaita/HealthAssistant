package com.example.healthassistant.di

import javax.inject.Qualifier
import javax.inject.Scope

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class CoroutineScropeIO

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerFragment