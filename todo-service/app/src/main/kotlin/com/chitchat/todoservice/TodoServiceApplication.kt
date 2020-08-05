package com.chitchat.todoservice

import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.stereotype.Service


@Service
@SpringBootApplication(exclude = [
    SecurityAutoConfiguration::class,
    ManagementWebSecurityAutoConfiguration::class
])
class TodoServiceApplication

fun main(args: Array<String>) {
    runApplication<TodoServiceApplication>(*args)
}