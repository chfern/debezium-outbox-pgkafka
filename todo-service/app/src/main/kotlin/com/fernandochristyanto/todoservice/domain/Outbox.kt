package com.fernandochristyanto.todoservice.domain

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Outbox(
        @Id
        val id: String = UUID.randomUUID().toString(),
        val payload: String
)