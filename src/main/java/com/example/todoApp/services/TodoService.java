package com.example.todoApp.services;

import com.example.todoApp.DTOs.TodoItemDTO;
import com.example.todoApp.services.interfaces.TodoServiceInterface;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

public class TodoService implements TodoServiceInterface {
    private static List<TodoItemDTO> todoItemsStore = new ArrayList<>();

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
