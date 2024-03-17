plugins {
    kotlin("jvm") version "1.9.23"

    // Apply the application plugin to add support for building a CLI application in Java.
    application
}

repositories {
    mavenCentral()
}

val kotestVersion = "5.8.1"
val arrowVersion  = "1.2.1"

dependencies {
    implementation(kotlin("stdlib"))

    implementation(platform("io.arrow-kt:arrow-stack:$arrowVersion"))
    implementation("io.arrow-kt:arrow-core")

    testImplementation("io.kotest:kotest-runner-junit5:$kotestVersion")
    testImplementation("io.kotest:kotest-assertions-core:$kotestVersion")
}

application {
    // Define the main class for the application.
    mainClass.set("app.AppKt")
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}