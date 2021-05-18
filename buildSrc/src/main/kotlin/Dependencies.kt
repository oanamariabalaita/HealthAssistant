@Suppress("SpellCheckingInspection")
object Dependencies {

    const val androidMaterial = "com.google.android.material:material:${Versions.material}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val androidCore = "androidx.core:core-ktx:${Versions.appCompat}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"
    const val room = "androidx.room:room-runtime:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val coroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val koin = "io.insert-koin:koin-android:${Versions.koin}"
    const val koinExt = "io.insert-koin:koin-android-ext:${Versions.koin}"
    const val koinWorkManager = "io.insert-koin:koin-androidx-workmanager:${Versions.koin}"
    const val koinCompose = "io.insert-koin:koin-androidx-compose:${Versions.koin}"
    const val scopeMob = "com.github.submob:scopemob:${Versions.scopeMob}"
    const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"

    // Navigation
    const val navigation = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val navigationDynamicFeatures =
        "androidx.navigation:navigation-dynamic-features-fragment:${Versions.navigation}"
    const val navigationTesting = "androidx.navigation:navigation-testing:${Versions.navigation}"
    const val navigationCompose =
        "androidx.navigation:navigation-compose:${Versions.navigationCompose}"

    // Compose
    const val composeUi = "androidx.compose.ui:ui:${Versions.compose}"
    const val composeRuntime = "androidx.compose.runtime:runtime:${Versions.compose}"
    const val composeConstraintLayout =
        "androidx.constraintlayout:constraintlayout-compose:${Versions.composeConstraintLayout}"
    const val composeUiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    const val composeFoundation = "androidx.compose.foundation:foundation:${Versions.compose}"
    const val composeMaterial = "androidx.compose.material:material:${Versions.compose}"
    const val composeMaterialIcons =
        "androidx.compose.material:material-icons-core:${Versions.compose}"
    const val composeMaterialIconsExt =
        "androidx.compose.material:material-icons-extended:${Versions.compose}"
    const val composeActivity = "androidx.activity:activity-compose:${Versions.composeActivity}"
    const val composeViewModel =
        "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.composeViewModel}"
    const val composeLiveData =
        "androidx.compose.runtime:runtime-livedata:${Versions.composeLiveData}"
    const val composeRxJava2 = "androidx.compose.runtime:runtime-rxjava2:${Versions.composeRxJava2}"
    const val composeLottie = "com.airbnb.android:lottie-compose:${Versions.composeLottie}"

    // Lifecycle
    const val lifecycleExtensions =
        "androidx.lifecycle:lifecycle-extensions:${Versions.androidxLifecycle}"
    const val lifecycleViewModel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.androidxLifecycle}"
    const val lifecycleLiveData =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.androidxLifecycle}"
    const val lifecycleRuntime =
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.androidxLifecycle}"
    const val lifecycleCommon =
        "androidx.lifecycle:lifecycle-common-java8:${Versions.androidxLifecycle}"

    // Networking
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    const val okhttpInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"
    const val kotlinSerialization =
        "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.kotlinSerialization}"
    const val kotlinSerializationConverter =
        "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${Versions.kotlinSerializationConverter}"

    // Tools
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
    const val steho = "com.facebook.stetho:stetho:${Versions.stetho}"
    const val stehoOkhttp = "com.facebook.stetho:stetho-okhttp3:${Versions.stetho}"
    const val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rx}"
    const val workManager = "androidx.work:work-runtime-ktx:${Versions.workManager}"
    const val workManagerRx = "androidx.work:work-rxjava2:${Versions.workManager}"
    const val chart = "com.github.PhilJay:MPAndroidChart:${Versions.chart}"

    // Test
    const val jUnit = "junit:junit:${Versions.jUnit}"
    const val mockK = "io.mockk:mockk:${Versions.mockK}"
    const val coroutinesTest =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
    const val composeJUnit4 = "androidx.compose.ui:ui-test-junit4:${Versions.composeJUnit4}"
}
