package com.example.todoApp.controllers;

import com.example.todoApp.DTOs.TodoItemDTO;
import com.example.todoApp.services.interfaces.TodoServiceInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

    private final TodoServiceInterface todoService;

    public TodoController(TodoServiceInterface todoService) {
        this.todoService = todoService;
    }

    @PostMapping("/todo")
    public void create(@RequestBody TodoItemDTO todoItem) {
        todoService.create(todoItem);
    }

    @GetMapping("/todo/{id}")
    public TodoItemDTO getTodoById(@PathVariable long id) {
        return todoService.getById(id);
    }

    @GetMapping("/todo-list")
    public List<TodoItemDTO> getTodoList() {
        return todoService.getTodoList();
    }

    @PutMapping("/todo/{id}")
    public void update(@PathVariable long id, @RequestBody TodoItemDTO todoItem) {
        todoService.update(id, todoItem);
    }

    @DeleteMapping("/todo/{id}")
    public void delete(@PathVariable long id) {
        todoService.delete(id);
    }
}
