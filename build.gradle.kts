plugins {
    `kotlin-dsl`
    id("com.gradle.plugin-publish") version "1.2.1"
}

group = "dev.botta.kotlin-conventions"
version = "1.0.0"

repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.23")
}

gradlePlugin {
    website = "https://github.com/nbottarini/kotlin-conventions-gradle-plugin"
    vcsUrl = "https://github.com/nbottarini/kotlin-conventions-gradle-plugin.git"

    plugins {
        create("kotlinConventions") {
            id = "dev.botta.kotlin-conventions"
            displayName = "Kotlin Conventions"
            description = "A plugin that applies Kotlin conventions"
            tags = listOf("kotlin", "conventions")
        }
    }
}
