package com.example.todoApp.controllers;

import com.example.todoApp.DTOs.TodoItemDTO;
import com.example.todoApp.services.interfaces.TodoServiceInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController {
    private final Logger logger = LoggerFactory.getLogger(TodoController.class);
    private final TodoServiceInterface todoService;

    public TodoController(TodoServiceInterface todoService) {
        this.todoService = todoService;
    }

    @PostMapping("/todo")
    public ResponseEntity<Void> create(@RequestBody TodoItemDTO todoItem) {
        try {
            todoService.create(todoItem);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
            logger.error("error", ex);
            throw ex;
        }
    }

    @GetMapping("/todo/{id}")
    public ResponseEntity<TodoItemDTO> getTodoById(@PathVariable long id) {
        try {
            return new ResponseEntity<>(todoService.getById(id), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("error", ex);
            throw ex;
        }
    }

    @GetMapping("/todo-list")
    public ResponseEntity<List<TodoItemDTO>> getTodoList() {
        try {
            return new ResponseEntity<>(todoService.getTodoList(), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("error", ex);
            throw ex;
        }
    }

    @PutMapping("/todo/{id}")
    public ResponseEntity<Void> update(@PathVariable long id, @RequestBody TodoItemDTO todoItem) {
        try {
            todoService.update(id, todoItem);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("error", ex);
            throw ex;
        }
    }

    @DeleteMapping("/todo/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        try {
            todoService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("error", ex);
            throw ex;
        }
    }
}
