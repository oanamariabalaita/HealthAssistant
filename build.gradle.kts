plugins {
    with(Plugins) {
        id(dependencyAnalysis) version Versions.dependencyAnalysis
        id(versions) version Versions.versionsVersion
    }
}

buildscript {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }
    dependencies {
        with(Classpaths) {
            classpath(androidBuildTools)
            classpath(kotlinGradlePlugin)
            classpath(navigation)
            classpath(serialization)
        }
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven(url = "https://jitpack.io")
        maven(url = "https://maven.google.com")
    }
}
