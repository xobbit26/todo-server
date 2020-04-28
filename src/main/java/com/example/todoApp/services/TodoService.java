package com.example.todoApp.services;

import com.example.todoApp.DAL.interfaces.TodoContextInterface;
import com.example.todoApp.DTOs.TodoItemDTO;
import com.example.todoApp.services.interfaces.TodoServiceInterface;

import java.awt.print.Pageable;
import java.util.List;

public class TodoService implements TodoServiceInterface {
    TodoContextInterface todoContext;

    public TodoService(TodoContextInterface todoContext) {
        this.todoContext = todoContext;
    }

    @Override
    public void create(TodoItemDTO todoItem) {
        //TODO: validation model
        //validateModel(todoItem);

        this.todoContext.create(todoItem);
    }

    @Override
    public TodoItemDTO getById(long id) {
        return this.todoContext.getById(id);
    }

    @Override
    public List<TodoItemDTO> get(Pageable page) {
        return this.todoContext.get(page);
    }

    @Override
    public List<TodoItemDTO> getAll() {
        return this.todoContext.getAll();
    }

    @Override
    public TodoItemDTO update(long id, TodoItemDTO todoItem) {
        return this.todoContext.update(id, todoItem);
    }

    @Override
    public void delete(long id) {
        this.todoContext.delete(id);
    }
}
