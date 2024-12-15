plugins {
    kotlin("jvm") version "2.1.0"
    kotlin("plugin.serialization") version "2.1.0"

    // Apply the application plugin to add support for building a CLI application in Java.
    application
}

repositories {
    mavenCentral()
}

val kotestVersion = "5.9.1"
val arrowVersion  = "1.2.4"
val serializationVersion  = "1.7.3"

dependencies {
    implementation(kotlin("stdlib"))

    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$serializationVersion")

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

tasks.named<JavaExec>("run").configure {
    standardInput = System.`in`
    standardOutput = System.`out`
}
