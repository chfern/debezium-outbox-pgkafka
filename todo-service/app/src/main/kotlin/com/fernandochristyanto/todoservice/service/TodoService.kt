package com.fernandochristyanto.todoservice.service

import com.fernandochristyanto.todoservice.domain.Todo
import com.fernandochristyanto.todoservice.dto.CreateTodoRequest
import com.fernandochristyanto.todoservice.dto.TodoDTO
import com.fernandochristyanto.todoservice.repository.TodoRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors.toList
import javax.transaction.Transactional

@Service
class TodoService(private val todoRepository: TodoRepository) {
    fun getTodos(): List<TodoDTO> = todoRepository.findAll().stream()
            .map { return@map with(it) { TodoDTO(id!!, taskName, completed) } }
            .collect(toList())

    @Transactional
    fun createTodo(createTodoRequest: CreateTodoRequest): TodoDTO {
        val newTodo = Todo.createNewTodo(createTodoRequest.taskName)
        val insertedTodo = todoRepository.save(newTodo)

        // Todo: Outbox publish

        return with(insertedTodo) { TodoDTO(id!!, taskName, completed) }
    }

    @Transactional
    fun deleteTodo(id: Long) {
        val todoToBeDeleted = todoRepository.findById(id)
                .orElseThrow { throw Exception("Todo with id $id not found") }
        todoRepository.delete(todoToBeDeleted)

        // Todo: Outbox publish
    }
}