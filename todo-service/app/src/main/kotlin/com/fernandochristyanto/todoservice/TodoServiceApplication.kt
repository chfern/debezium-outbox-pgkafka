package com.fernandochristyanto.todoservice

import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [
    SecurityAutoConfiguration::class,
    ManagementWebSecurityAutoConfiguration::class
])
class TodoServiceApplication {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<TodoServiceApplication>(*args)
        }
    }
}