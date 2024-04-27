import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
}

repositories {
    mavenCentral()
}

tasks.withType<KotlinCompile> { kotlinOptions.jvmTarget = "17" }

tasks.withType<Test> {
    useJUnitPlatform { excludeTags("slow") }
}

tasks.register<Test>("slowTest") {
    group = "verification"
    useJUnitPlatform { includeTags("slow") }
}

tasks.register<Test>("allTests") {
    group = "verification"
    useJUnitPlatform { }
}

tasks.withType<Test>().configureEach {
    reports.html.required.set(false)
    reports.junitXml.required.set(false)
}

tasks.named<Copy>("processResources") {
    duplicatesStrategy = DuplicatesStrategy.INCLUDE
}

tasks.named<Copy>("processTestResources") {
    duplicatesStrategy = DuplicatesStrategy.INCLUDE
}

kotlin {
    sourceSets["main"].apply {
        kotlin.srcDirs("src", "generated")
        resources.srcDirs("resources")
    }
    sourceSets["test"].apply {
        kotlin.srcDir("test")
        resources.srcDir("test_resources")
    }
}

java {
    sourceSets["main"].apply {
        java.srcDirs("src", "generated")
        resources.srcDirs("resources")
    }
    sourceSets["test"].apply {
        java.srcDir("test")
        resources.srcDir("test_resources")
    }
}

