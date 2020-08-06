package com.fernandochristyanto.todoservice.controller

import com.fernandochristyanto.todoservice.dto.CreateTodoRequest
import com.fernandochristyanto.todoservice.dto.TodoDTO
import com.fernandochristyanto.todoservice.service.TodoService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/todos")
class TodoController(private val todoService: TodoService) {
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun get(): List<TodoDTO> = todoService.getTodos()

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody createTodoRequest: CreateTodoRequest): TodoDTO = todoService.createTodo(createTodoRequest)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun delete(@PathVariable("id") id: Long) = todoService.deleteTodo(id)
}