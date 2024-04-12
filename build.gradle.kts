import com.vanniktech.maven.publish.SonatypeHost

plugins {
    `kotlin-dsl`
    id("com.vanniktech.maven.publish") version "0.28.0"
}

group = "dev.botta"
version = "0.1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.23")
}

mavenPublishing {
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL, automaticRelease = true)
    signAllPublications()
    coordinates(project.group.toString(), "kotlin-conventions", project.version.toString())

    pom {
        name.set("Kotlin Conventions Gradle Plugin")
        description.set("A plugin that applies Kotlin conventions")
        inceptionYear.set("2024")
        url.set("https://github.com/nbottarini/kotlin-conventions-gradle-plugin")

        licenses {
            license {
                name.set("MIT License")
                url.set("http://www.opensource.org/licenses/mit-license.php")
                distribution.set("http://www.opensource.org/licenses/mit-license.php")
            }
        }

        developers {
            developer {
                id.set("nbottarini")
                name.set("Nicolas Bottarini")
                url.set("https://github.com/nbottarini/")
                email.set("nicolasbottarini@gmail.com")
            }
        }

        scm {
            connection.set("scm:git:git://github.com/nbottarini/kotlin-conventions-gradle-plugin.git")
            developerConnection.set("scm:git:ssh://github.com/nbottarini/kotlin-conventions-gradle-plugin.git")
            url.set("https://github.com/nbottarini/kotlin-conventions-gradle-plugin")
        }
    }
}

tasks.named<Copy>("processResources") {
    duplicatesStrategy = DuplicatesStrategy.INCLUDE
}
