plugins {
    with(Plugins) {
        id(dependencyAnalysis) version Versions.dependencyAnalysis
        id(versions) version Versions.versionsVersion
    }
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        with(Classpaths) {
            classpath(androidBuildTools)
            classpath(kotlinGradlePlugin)
            classpath(kotlinExtensions)
            classpath(navigation)
            classpath(serialization)
        }
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven(url = "https://jitpack.io")
        maven(url = "https://maven.google.com")
        maven(url = "https://kotlin.bintray.com/kotlinx")
        maven(url = "https://oss.sonatype.org/content/repositories/snapshots/")
        if (Versions.compose.endsWith("SNAPSHOT")) {
            maven(url = "https://androidx.dev/snapshots/builds/${Versions.composeSnapshot}/artifacts/repository/")
        }
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
        allWarningsAsErrors = true
        freeCompilerArgs += "-Xopt-in=kotlinx.coroutines.FlowPreview"
        freeCompilerArgs += "-Xopt-in=kotlin.Experimental"
        freeCompilerArgs += "-Xopt-in=kotlinx.coroutines.ExperimentalCoroutinesApi"
    }
}