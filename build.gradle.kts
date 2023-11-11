plugins {
    kotlin("jvm") version "1.9.20"
    application
}

group = "top.takuron.ncpuy"
version = "1.1.0002"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("MainKt")
}