package com.fernandochristyanto.todoservice.event

data class TodoCreatedEvent(
        val id: Long,
        val taskName: String
)