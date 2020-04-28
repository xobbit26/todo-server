package com.example.todoApp.DAL;

import com.example.todoApp.DAL.interfaces.TodoContextInterface;
import com.example.todoApp.DTOs.TodoItemDTO;

import java.awt.print.Pageable;
import java.util.List;

public class TodoDbContext implements TodoContextInterface {

    @Override
    public void create(TodoItemDTO todoItem) {

    }

    @Override
    public TodoItemDTO getById(long id) {
        return null;
    }

    @Override
    public List<TodoItemDTO> get(Pageable page) {
        return null;
    }

    @Override
    public List<TodoItemDTO> getAll() {
        return null;
    }

    @Override
    public TodoItemDTO update(long id, TodoItemDTO todoItem) {
        return null;
    }

    @Override
    public void delete(long id) {

    }
}
