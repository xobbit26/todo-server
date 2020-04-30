package com.example.todoApp.services;

import com.example.todoApp.DAL.interfaces.TodoContextInterface;
import com.example.todoApp.DTOs.TodoItemDTO;
import com.example.todoApp.exceptions.ValidationException;
import com.example.todoApp.services.interfaces.TodoServiceInterface;
import org.springframework.util.StringUtils;

import java.time.Instant;
import java.util.List;

public class TodoService implements TodoServiceInterface {
    TodoContextInterface todoContext;

    public TodoService(TodoContextInterface todoContext) {
        this.todoContext = todoContext;
    }

    @Override
    public void create(TodoItemDTO todoItem) {
        validateModel(todoItem);
        setTodoCreatedTime(todoItem);
        this.todoContext.create(todoItem);
    }

    @Override
    public TodoItemDTO getById(long id) {
        return this.todoContext.getById(id);
    }

    @Override
    public List<TodoItemDTO> getTodoList() {
        return this.todoContext.getTodoList();
    }

    @Override
    public TodoItemDTO update(long id, TodoItemDTO todoItem) {
        return this.todoContext.update(id, todoItem);
    }

    @Override
    public void delete(long id) {
        this.todoContext.delete(id);
    }


    private void validateModel(TodoItemDTO todoItem) {
        if (todoItem == null) {
            throw new ValidationException("todo item is null");
        }
        if (StringUtils.isEmpty(todoItem.getText())) {
            throw new ValidationException("todo text is null or empty");
        }
    }

    private void setTodoCreatedTime(TodoItemDTO todoItem) {
        if(todoItem.getCreatedOn() == null){
            todoItem.setCreatedOn(Instant.now());
        }
    }
}
