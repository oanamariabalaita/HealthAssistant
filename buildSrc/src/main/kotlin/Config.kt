@file:Suppress("SpellCheckingInspection")

object Versions {
    const val kotlinVersion = "1.3.72"
    const val navigationVersion = "2.2.2"
    const val androidPluginVersion = "4.0.1"
    const val daggerVersion = "2.27"
    const val androidxLifecycleVersion = "2.2.0"
    const val appCompatVersion = "1.1.0"
    const val constraintLayoutVersion = "2.0.0-beta4"
    const val coroutinesVersion = "1.3.0-RC"
    const val glideVersion = "4.10.0"
    const val materialVersion = "1.1.0"
    const val recyclerViewVersion = "1.1.0"
    const val roomVersion = "2.2.5"
    const val moshiVersion = "1.9.3"
    const val okhttpVersion = "3.10.0"
    const val retrofitVersion = "2.8.1"
    const val stethoVersion = "1.5.1"
    const val timberVersion = "4.7.1"
    const val rxVersion = "2.1.1"
    const val workManagerVersion = "2.3.4"
    const val chartVersion = "v3.1.0"
    const val jUnitVersion = "4.13"
    const val mockKVersion = "1.10.0"
    const val versionsVersion = "0.29.0"
    const val baseVersion = "1.3.0"
}

object Dependencies {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlinVersion}"
    const val androidMaterial = "com.google.android.material:material:${Versions.materialVersion}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayoutVersion}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompatVersion}"
    const val androidCore = "androidx.core:core-ktx:${Versions.appCompatVersion}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerViewVersion}"
    const val room = "androidx.room:room-runtime:${Versions.roomVersion}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.roomVersion}"
    const val glide = "com.github.bumptech.glide:glide:${Versions.glideVersion}"
    const val kotlinJdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlinVersion}"
    const val coroutines =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesVersion}"
    const val coroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesVersion}"
    const val navigation =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigationVersion}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigationVersion}"
    const val daggerAndroidSupport =
        "com.google.dagger:dagger-android-support:${Versions.daggerVersion}"
    const val dagger = "com.google.dagger:dagger:${Versions.daggerVersion}"
    const val baseClasses = "com.github.SUB-MOB:basemob:${Versions.baseVersion}"

    //LiveData
    const val lifecycleExtensions =
        "androidx.lifecycle:lifecycle-extensions:${Versions.androidxLifecycleVersion}"
    const val lifecycleViewModel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.androidxLifecycleVersion}"
    const val lifecycleLiveData =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.androidxLifecycleVersion}"
    const val lifecycleRuntime =
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.androidxLifecycleVersion}"

    // Networking
    const val moshi = "com.squareup.moshi:moshi:${Versions.moshiVersion}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    const val retrofitConverter =
        "com.squareup.retrofit2:converter-gson:${Versions.retrofitVersion}"
    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttpVersion}"
    const val okhttpInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.okhttpVersion}"

    // Tools
    const val timber = "com.jakewharton.timber:timber:${Versions.timberVersion}"
    const val steho = "com.facebook.stetho:stetho:${Versions.stethoVersion}"
    const val stehoOkhttp = "com.facebook.stetho:stetho-okhttp3:${Versions.stethoVersion}"
    const val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxVersion}"
    const val workManager = "androidx.work:work-runtime-ktx:${Versions.workManagerVersion}"
    const val workManagerRx = "androidx.work:work-rxjava2:${Versions.workManagerVersion}"
    const val chart = "com.github.PhilJay:MPAndroidChart:${Versions.chartVersion}"
}

object TestDependencies {
    const val jUnit = "junit:junit:${Versions.jUnitVersion}"
    const val mockK = "io.mockk:mockk:${Versions.mockKVersion}"
    const val coroutinesTest =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutinesVersion}"
}

object Annotations {
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.daggerVersion}"
    const val daggerProcessor =
        "com.google.dagger:dagger-android-processor:${Versions.daggerVersion}"
    const val moshi = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshiVersion}"
    const val room = "androidx.room:room-compiler:${Versions.roomVersion}"
}

object Classpaths {
    const val androidBuildTools = "com.android.tools.build:gradle:${Versions.androidPluginVersion}"
    const val kotlinGradlePlugin =
        "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}"
    const val navigation =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigationVersion}"
}

object Plugins {
    const val application = "com.android.application"
    const val versions = "com.github.ben-manes.versions"
    const val safeargs = "androidx.navigation.safeargs"
    const val android = "android"
    const val kapt = "kapt"
}
