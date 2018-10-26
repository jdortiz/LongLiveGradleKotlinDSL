import org.jetbrains.kotlin.config.KotlinCompilerVersion

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
}

android {
    compileSdkVersion(28)
    defaultConfig {
        applicationId = "com.canonicalexamples.realprogrammers"
        minSdkVersion(19)
        targetSdkVersion(28)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(kotlin(module = "stdlib-jdk7", version = KotlinCompilerVersion.VERSION))
    val versions: Map<String, String> by rootProject.extra
    implementation(group = "com.android.support", name = "appcompat-v7", version = versions["appcompat"])
    implementation(group = "com.android.support.constraint", name = "constraint-layout", version = versions["constraintLayout"])
    testImplementation(group = "junit", name = "junit", version = versions["junit"])
    androidTestImplementation(group = "com.android.support.test", name = "runner", version = versions["supportTest"])
    androidTestImplementation(group = "com.android.support.test.espresso", name = "espresso-core", version = versions["espresso"])
}
