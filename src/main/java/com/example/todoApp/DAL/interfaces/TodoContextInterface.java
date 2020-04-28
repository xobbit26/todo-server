package com.example.todoApp.DAL.interfaces;

import com.example.todoApp.DTOs.TodoItemDTO;

import java.awt.print.Pageable;
import java.util.List;

public interface TodoContextInterface {
    void create(TodoItemDTO todoItem);
    TodoItemDTO getById(long id);
    List<TodoItemDTO> get(Pageable page);
    List<TodoItemDTO> getAll();
    TodoItemDTO update(long id, TodoItemDTO todoItem);
    void delete(long id);
}
