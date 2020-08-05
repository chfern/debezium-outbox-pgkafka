description = "app"

fun gradleScript(scriptName: String): File {
    return file("${rootProject.projectDir}/gradle/${scriptName}.gradle.kts")
}

buildscript {
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:2.3.1.RELEASE")
    }
}

plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    id("org.flywaydb.flyway")
    id("org.jetbrains.kotlin.plugin.noarg")
    kotlin("jvm")
    kotlin("plugin.spring")
    kotlin("plugin.jpa")
}

dependencies {
    implementation(Libs.kotlin_stdlib_jdk8)
    implementation(Libs.kotlin_reflect)
    implementation(Libs.springbootstarter_actuator)
    implementation(Libs.springbootstarter_security)
    implementation(Libs.springbootstarter_web)
    implementation(Libs.springbootstarter_parent)
    implementation(Libs.jackson_module_kotlin)
    implementation(Libs.flyway_core)
    implementation(Libs.springbootstarter_data_jpa)
    runtimeOnly(Libs.RuntimeOnly.postgresql)
    runtimeOnly(Libs.RuntimeOnly.springboot_devtools)

    testImplementation(Libs.Test.springbootstarter_test) {
        exclude(LibNames.junit_vintage_engine)
    }
    testImplementation(Libs.Test.springsecurity_test)
}

springBoot {
    buildInfo()
    mainClassName = "com.fernandochristyanto.todoservice.TodoServiceApplication"
}

tasks.getByName<Jar>("jar") {
    manifest {
        attributes["Main-Class"] = "com.fernandochristyanto.todoservice.TodoServiceApplication"
    }
}

flyway {
    val flywayUrl = System.getenv("spring.datasource.url") ?: "jdbc:postgresql://db:5432/todo_db"
    val flywayUser = System.getenv("spring.datasource.username") ?: "postgres"
    val flywayPassword = System.getenv("spring.datasource.password") ?: "AAAaaa123!@#"

    url = flywayUrl
    user = flywayUser
    password = flywayPassword
    schemas = arrayOf("public")
    cleanDisabled = true
    cleanOnValidationError = false
    locations= arrayOf("classpath:flyway/postgresql")
}