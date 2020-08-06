package com.fernandochristyanto.todoservice.repository

import com.fernandochristyanto.todoservice.domain.Todo
import org.springframework.data.jpa.repository.JpaRepository

interface TodoRepository : JpaRepository<Todo, Long>