plugins {
    with(Plugins) {
        id(application)
        id(safeargs)
        id(serialization)
        kotlin(android)
        kotlin(kapt)
    }
}

android {
    with(ProjectSettings) {
        compileSdkVersion(projectCompileSdkVersion)

        defaultConfig {
            minSdkVersion(projectMinSdkVersion)
            targetSdkVersion(projectTargetSdkVersion)

            multiDexEnabled = true
            vectorDrawables.useSupportLibrary = true
            applicationId = applicationId

            versionCode = getVersionCode(project)
            versionName = getVersionName(project)
        }

        kotlinOptions {
            jvmTarget = "1.8"
            freeCompilerArgs = listOf("-Xjvm-default=compatibility")
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }

        buildFeatures {
            viewBinding = true
            dataBinding = true
        }
    }
}

dependencies {
    with(Dependencies) {
        implementation(kotlin)
        implementation(kotlinJdk8)
        implementation(appCompat)
        implementation(androidCore)
        implementation(timber)
        implementation(steho)
        implementation(stehoOkhttp)
        implementation(rxAndroid)
        implementation(workManagerRx)
        implementation(workManager)
        implementation(scopeMob)

        // UI
        implementation(androidMaterial)
        implementation(constraintLayout)
        implementation(recyclerView)
        implementation(glide)
        implementation(chart)

        // DI
        implementation(dagger)
        implementation(daggerAndroidSupport)

        // Network
        implementation(retrofit)
        implementation(retrofitConverter)
        implementation(okhttp)
        implementation(okhttpInterceptor)
        implementation(kotlinSerialization)
        implementation(kotlinSerializationConverter)

        // Local DB
        implementation(room)
        implementation(roomKtx)

        // Navigation
        implementation(navigation)
        implementation(navigationUi)

        // Lifecycle
        implementation(lifecycleCommon)
        implementation(lifecycleExtensions)
        implementation(lifecycleLiveData)
        implementation(lifecycleRuntime)
        implementation(lifecycleViewModel)

        // Coroutines
        implementation(coroutines)
        implementation(coroutinesCore)

        // Test
        testImplementation(jUnit)
        testImplementation(mockK)
        testImplementation(coroutinesTest)
    }

    with(Annotations) {
        kapt(daggerCompiler)
        kapt(daggerProcessor)
        kapt(room)
    }
}
