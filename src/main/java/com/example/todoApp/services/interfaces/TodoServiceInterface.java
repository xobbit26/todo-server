package com.example.todoApp.services.interfaces;

import com.example.todoApp.DTOs.TodoItemDTO;

import java.util.List;

public interface TodoServiceInterface {
    void create(TodoItemDTO todoItem);
    TodoItemDTO getById(long id);
    List<TodoItemDTO> getTodoList();
    void update(long id, TodoItemDTO todoItem);
    void delete(long id);
}
