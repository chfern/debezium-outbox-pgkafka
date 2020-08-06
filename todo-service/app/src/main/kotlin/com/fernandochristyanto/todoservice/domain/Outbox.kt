package com.fernandochristyanto.todoservice.domain

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Outbox(
        @Id
        val id: String,
        val payload: String,
        val type: String
) {
    companion object {
        fun createNewOutbox(payload: String, type: String): Outbox = Outbox(UUID.randomUUID().toString(), payload, type)
    }
}