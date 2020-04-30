package com.example.todoApp.DAL.interfaces;

import com.example.todoApp.DTOs.TodoItemDTO;

import java.util.List;

public interface TodoContextInterface {
    void create(TodoItemDTO todoItem);
    TodoItemDTO getById(long id);
    List<TodoItemDTO> getTodoList();
    TodoItemDTO update(long id, TodoItemDTO todoItem);
    void delete(long id);
}
