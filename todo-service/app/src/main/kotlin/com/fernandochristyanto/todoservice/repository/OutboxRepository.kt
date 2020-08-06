package com.fernandochristyanto.todoservice.repository

import com.fernandochristyanto.todoservice.domain.Outbox
import org.springframework.data.jpa.repository.JpaRepository

interface OutboxRepository : JpaRepository<Outbox, String>