import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.31"
}

group = "org.quickstart"
version = "1.0"

repositories {
//    maven("http://maven.aliyun.com/nexus/content/groups/public/")
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactive:1.5.2")
    implementation("io.lettuce:lettuce-core:6.1.5.RELEASE")
    implementation("org.slf4j:slf4j-api:1.7.30")

    testImplementation(kotlin("test-junit"))
}

tasks.test {
    useJUnit()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}