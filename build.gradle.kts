import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.31"
}

group = "org.quickstart"
version = "1.0"

repositories {
    maven("http://maven.aliyun.com/nexus/content/groups/public/")
    mavenCentral()
}

dependencies {
//    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:%kotlinVersion%")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.3")
    testImplementation(kotlin("test-junit"))
}

tasks.test {
    useJUnit()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}