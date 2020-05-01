package com.example.todoApp.DAL;

import com.example.todoApp.DAL.interfaces.TodoContextInterface;
import com.example.todoApp.DTOs.TodoItemDTO;

import java.util.List;
import java.util.Optional;

public class TodoDbContext implements TodoContextInterface {

    @Override
    public void create(TodoItemDTO todoItem) {

    }

    @Override
    public Optional<TodoItemDTO> getById(long id) {
        return Optional.empty();
    }

    @Override
    public List<TodoItemDTO> getTodoList() {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public void save(TodoItemDTO todoItem) {

    }
}
