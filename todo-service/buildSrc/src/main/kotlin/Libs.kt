internal object LibVersion {
    const val kotlin_stdlib_jdk8 = "1.3.71"
    const val kotlin_reflect = "1.3.71"

    const val springbootstarter_actuator = "2.3.1.RELEASE"
    const val springbootstarter_parent = "2.3.1.RELEASE"
    const val springbootstarter_security = "2.3.1.RELEASE"
    const val springbootstarter_web = "2.3.1.RELEASE"
    const val springbootstarter_data_jpa = "2.3.1.RELEASE"
    const val spring_context = "5.2.6.RELEASE"

    const val jackson_module_kotlin = "2.11.0"

    const val flyway_core = "6.4.4"
    const val hibernate_core = "5.4.17.Final"

    const val spring_kafka = "2.5.3.RELEASE"

    object RuntimeOnly {
        const val postgresql = "42.2.14"
        const val springboot_devtools = "2.3.1.RELEASE"
    }

    object Test {
        const val springbootstarter_test = "2.3.1.RELEASE"
        const val springsecurity_test = "5.3.3.RELEASE"
    }
}

object LibNames {
    const val kotlin_stdlib_jdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8"
    const val kotlin_reflect = "org.jetbrains.kotlin:kotlin-reflect"

    const val springbootstarter_actuator = "org.springframework.boot:spring-boot-starter-actuator"
    const val springbootstarter_parent = "org.springframework.boot:spring-boot-starter-parent"
    const val springbootstarter_security = "org.springframework.boot:spring-boot-starter-security"
    const val springbootstarter_web = "org.springframework.boot:spring-boot-starter-web"
    const val springbootstarter_data_jpa = "org.springframework.boot:spring-boot-starter-data-jpa"
    const val springboot_devtools = "org.springframework.boot:spring-boot-devtools"
    const val springbootstarter_test= "org.springframework.boot:spring-boot-starter-test"
    const val springsecurity_test= "org.springframework.security:spring-security-test"

    const val jackson_module_kotlin = "com.fasterxml.jackson.module:jackson-module-kotlin"

    const val flyway_core = "org.flywaydb:flyway-core"
    const val postgresql = "org.postgresql:postgresql"

    const val spring_kafka = "org.springframework.kafka:spring-kafka"

    const val junit_vintage_engine = "org.junit.vintage:junit-vintage-engine"
}

object Libs {
    const val kotlin_stdlib_jdk8 = "${LibNames.kotlin_stdlib_jdk8}:${LibVersion.kotlin_stdlib_jdk8}"
    const val kotlin_reflect = "${LibNames.kotlin_reflect}:${LibVersion.kotlin_reflect}"

    const val springbootstarter_actuator = "${LibNames.springbootstarter_actuator}:${LibVersion.springbootstarter_actuator}"
    const val springbootstarter_parent = "${LibNames.springbootstarter_parent}:${LibVersion.springbootstarter_parent}"
    const val springbootstarter_security = "${LibNames.springbootstarter_security}:${LibVersion.springbootstarter_security}"
    const val springbootstarter_web = "${LibNames.springbootstarter_web}:${LibVersion.springbootstarter_web}"
    const val springbootstarter_data_jpa = "${LibNames.springbootstarter_data_jpa}:${LibVersion.springbootstarter_data_jpa}"

    const val jackson_module_kotlin = "${LibNames.jackson_module_kotlin}:${LibVersion.jackson_module_kotlin}"

    const val flyway_core = "${LibNames.flyway_core}:${LibVersion.flyway_core}"

    const val spring_kafka = "${LibNames.spring_kafka}:${LibVersion.spring_kafka}"

    object RuntimeOnly {
        const val postgresql = "${LibNames.postgresql}:${LibVersion.RuntimeOnly.postgresql}"
        const val springboot_devtools = "${LibNames.springboot_devtools}:${LibVersion.RuntimeOnly.springboot_devtools}"
    }

    object Test {
        const val springbootstarter_test= "${LibNames.springbootstarter_test}:${LibVersion.Test.springbootstarter_test}"
        const val springsecurity_test= "${LibNames.springsecurity_test}:${LibVersion.Test.springsecurity_test}"
    }
}