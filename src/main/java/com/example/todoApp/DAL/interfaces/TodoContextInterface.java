package com.example.todoApp.DAL.interfaces;

import com.example.todoApp.DTOs.TodoItemDTO;

import java.util.List;
import java.util.Optional;

public interface TodoContextInterface {
    void create(TodoItemDTO todoItem);
    Optional<TodoItemDTO> getById(long id);
    List<TodoItemDTO> getTodoList();
    void delete(long id);
    void save(TodoItemDTO todoItem);
}
