package com.fernandochristyanto.todoservice.dto

data class TodoDTO(
        val id: Long,
        val taskName: String,
        val completed: Boolean
)