package com.example.todoApp.services.interfaces;

import com.example.todoApp.DTOs.TodoItemDTO;

import java.awt.print.Pageable;
import java.util.List;

public interface TodoServiceInterface {
    void create(TodoItemDTO todoItem);
    TodoItemDTO getById(long id);
    List<TodoItemDTO> get(Pageable page);
    List<TodoItemDTO> getAll();
    TodoItemDTO update(long id, TodoItemDTO todoItem);
    void delete(long id);
}
