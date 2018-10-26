// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    val kotlinVersion: String by extra { "1.2.71" }
    @Suppress("UNUSED_VARIABLE")
    val versions: Map<String, String> by extra { mapOf("appcompat" to "28.0.0",
        "constraintLayout" to "1.1.3",
        "junit" to "4.12",
        "supportTest" to "1.0.2",
        "espresso" to "3.0.2") }
    repositories {
        google()
        jcenter()
        maven(url = "https://plugins.gradle.org/m2/")
    }
    dependencies {
        classpath("com.android.tools.build:gradle:3.2.1")
        classpath(kotlin("gradle-plugin", version = kotlinVersion))

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

plugins {
    id("com.dorongold.task-tree") version("1.3.1")
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

tasks {
    @Suppress("UNUSED_VARIABLE")
    val clean by creating(Delete::class) {
        delete(rootProject.buildDir)
    }
}
