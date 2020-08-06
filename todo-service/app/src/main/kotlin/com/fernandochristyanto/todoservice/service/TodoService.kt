package com.fernandochristyanto.todoservice.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.fernandochristyanto.todoservice.domain.Outbox
import com.fernandochristyanto.todoservice.domain.Todo
import com.fernandochristyanto.todoservice.dto.CreateTodoRequest
import com.fernandochristyanto.todoservice.dto.TodoDTO
import com.fernandochristyanto.todoservice.event.TodoCreatedEvent
import com.fernandochristyanto.todoservice.event.TodoDeletedEvent
import com.fernandochristyanto.todoservice.repository.OutboxRepository
import com.fernandochristyanto.todoservice.repository.TodoRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors.toList
import javax.transaction.Transactional

@Service
class TodoService(private val todoRepository: TodoRepository,
                  private val outboxRepository: OutboxRepository,
                  private val objectMapper: ObjectMapper) {
    fun getTodos(): List<TodoDTO> = todoRepository.findAll().stream()
            .map { return@map with(it) { TodoDTO(id!!, taskName, completed) } }
            .collect(toList())

    @Transactional
    fun createTodo(createTodoRequest: CreateTodoRequest): TodoDTO {
        val newTodo = Todo.createNewTodo(createTodoRequest.taskName)
        val insertedTodo = todoRepository.save(newTodo)

        val todoCreatedEvent = with(insertedTodo) { TodoCreatedEvent(id!!, taskName) }
        val newOutbox = Outbox.createNewOutbox(
                objectMapper.writeValueAsString(todoCreatedEvent), TodoCreatedEvent::class.java.simpleName)
        outboxRepository.save(newOutbox)

        return with(insertedTodo) { TodoDTO(id!!, taskName, completed) }
    }

    @Transactional
    fun deleteTodo(id: Long) {
        val todoToBeDeleted = todoRepository.findById(id)
                .orElseThrow { throw Exception("Todo with id $id not found") }
        todoRepository.delete(todoToBeDeleted)

        val todoDeletedEvent = TodoDeletedEvent(id)
        val newOutbox = Outbox.createNewOutbox(
                objectMapper.writeValueAsString(todoDeletedEvent), TodoDeletedEvent::class.java.simpleName)
        outboxRepository.save(newOutbox)
    }
}