plugins {
    with(Plugins) {
        id(application)
        kotlin(android)
        id(safeargs)
        id(serialization)
        kotlin(kapt)
    }
}

android {
    with(ProjectSettings) {
        compileSdk = projectCompileSdkVersion

        defaultConfig {
            minSdk = projectMinSdkVersion
            targetSdk = projectTargetSdkVersion

            multiDexEnabled = true
            vectorDrawables.useSupportLibrary = true
            applicationId = applicationId

            versionCode = getVersionCode(project)
            versionName = getVersionName(project)
        }

        kotlinOptions {
            jvmTarget = "11"
            freeCompilerArgs = listOf("-Xjvm-default=compatibility")
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_11
            targetCompatibility = JavaVersion.VERSION_11
        }

        buildFeatures {
            compose = true
            viewBinding = true
            dataBinding = true
        }

        composeOptions {
            kotlinCompilerExtensionVersion = Versions.compose
        }
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "11"
        freeCompilerArgs += listOf("-Xopt-in=kotlin.RequiresOptIn")
    }
}

dependencies {
    with(Dependencies) {
        implementation(appCompat)
        implementation(androidCore)
        implementation(timber)
        implementation(steho)
        implementation(stehoOkhttp)
        implementation(rxAndroid)
        implementation(workManagerRx)
        implementation(workManager)
        implementation(scopeMob)
        implementation(stdlib)
        implementation(systemUiController)

        // UI
        implementation(androidMaterial)
        implementation(recyclerView)
        implementation(glide)
        implementation(chart)

        // Network
        implementation(retrofit)
        implementation(retrofitConverter)
        implementation(okhttp)
        implementation(okhttpInterceptor)
        implementation(kotlinSerialization)
        implementation(kotlinSerializationConverter)

        // Room
        implementation(room)
        implementation(roomKtx)

        // Navigation
        implementation(navigation)
        implementation(navigationUi)
        implementation(navigationDynamicFeatures)
        implementation(navigationTesting)
        implementation(navigationCompose)

        // Compose
        implementation(composeUi)
        implementation(composeRuntime)
        implementation(composeUiTooling)
        implementation(composeFoundation)
        implementation(composeConstraintLayout)
        implementation(composeMaterial)
        implementation(composeMaterialIcons)
        implementation(composeMaterialIconsExt)
        implementation(composeActivity)
        implementation(composeViewModel)
        implementation(composeLiveData)
        implementation(composeRxJava2)
        implementation(composeLottie)

        // Lifecycle
        implementation(lifecycleCommon)
        implementation(lifecycleExtensions)
        implementation(lifecycleLiveData)
        implementation(lifecycleRuntime)
        implementation(lifecycleViewModel)

        // Coroutines
        implementation(coroutines)
        implementation(coroutinesCore)

        // Koin
        implementation(koin)
        implementation(koinExt)
        implementation(koinCompose)
        implementation(koinWorkManager)

        // Test
        testImplementation(jUnit)
        testImplementation(mockK)
        testImplementation(coroutinesTest)
        androidTestImplementation(composeJUnit4)
    }

    with(Annotations) {
        kapt(room)
    }
}
