package com.example.todoApp.controllers;

import com.example.todoApp.DTOs.TodoItemDTO;
import com.example.todoApp.services.interfaces.TodoServiceInterface;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController {
    private TodoServiceInterface todoService;

    public TodoController(TodoServiceInterface todoService) {
        this.todoService = todoService;
    }

    @PostMapping("/todo")
    public void create(@RequestBody TodoItemDTO todoItem) {
        todoService.create(todoItem);
    }

    @GetMapping("/todo/{id}")
    public TodoItemDTO getTodoById(@RequestParam long id) {
        return todoService.getById(id);
    }

    @GetMapping("/todo-list")
    public List<TodoItemDTO> getTodoList(Pageable pageable) {
        return todoService.getAll();
    }

    @GetMapping("/all-todo-list")
    public List<TodoItemDTO> getAllTodoList() {
        return todoService.getAll();
    }

    @PutMapping("/todo/{id}")
    public TodoItemDTO update(@RequestParam long id, @RequestBody TodoItemDTO todoItem) {
        return todoService.update(id, todoItem);
    }

    @DeleteMapping("/todo/{id}")
    public void delete(@RequestParam long id) {
        todoService.delete(id);
    }
}
