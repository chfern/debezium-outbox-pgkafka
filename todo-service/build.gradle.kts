import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar

buildscript {
    repositories {
        mavenCentral()
    }
}

plugins {
    id("org.springframework.boot") version PluginVersions.ORG_SPRINGFRAMEWORK_BOOT apply false
    id("io.spring.dependency-management") version PluginVersions.IO_SPRING_DEPENDENCYMANAGEMENT apply false
    id("org.flywaydb.flyway") version PluginVersions.ORG_FLYWAYDB_FLYWAY apply false
    id("org.jetbrains.kotlin.plugin.noarg") version PluginVersions.KOTLIN_PLUGIN_NOARG apply false
    kotlin("jvm") version PluginVersions.KOTLIN_JVM apply false
    kotlin("plugin.spring") version PluginVersions.KOTLIN_PLUGIN_SPRING apply false
    kotlin("plugin.jpa") version PluginVersions.KOTLIN_PLUGIN_JPA apply false
}

allprojects {
    group = Config.GROUP_NAME
    version = Config.VERSION

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = Config.JVM_TARGET
        }
    }
}

subprojects {
    repositories {
        mavenCentral()
    }

    apply {
        plugin("io.spring.dependency-management")
        plugin("kotlin")
        plugin("kotlin-spring")
    }
}

configure(subprojects.filter { it.name != "app" }) {
    afterEvaluate {
        tasks.getByName<BootJar>("bootJar") {
            enabled = false
        }

        tasks.getByName<Jar>("jar") {
            enabled = true
        }
    }
}