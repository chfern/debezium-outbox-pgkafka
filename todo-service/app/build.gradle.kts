description = "app"

fun gradleScript(scriptName: String): File {
    return file("${rootProject.projectDir}/gradle/${scriptName}.gradle.kts")
}

buildscript {
    project.apply {
//        from("${rootProject.projectDir}/gradle/flyway.gradle.kts")
    }
}

plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    id("org.flywaydb.flyway")
    kotlin("jvm")
    kotlin("plugin.spring")
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

flyway {
    val flywayUrl = System.getenv("spring.datasource.url") ?: "jdbc:postgresql://127.0.0.1:5432/userdb"
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