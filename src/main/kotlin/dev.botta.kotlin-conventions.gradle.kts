plugins {
    kotlin("jvm")
}

repositories {
    mavenCentral()
}

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
    sourceSets["main"].kotlin.srcDirs("src", "generated")
    sourceSets["main"].resources.srcDirs("resources")
    sourceSets["test"].kotlin.srcDir("test")
    sourceSets["test"].resources.srcDir("test_resources")
}

java {
    sourceSets["main"].java.srcDirs("src", "generated")
    sourceSets["main"].resources.srcDirs("resources")
    sourceSets["test"].java.srcDir("test")
    sourceSets["test"].resources.srcDir("test_resources")
}
