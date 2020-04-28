package com.example.todoApp.exceptions;

public class TodoItemNotFoundException extends RuntimeException{
    public TodoItemNotFoundException(String message) {
        super(message);
    }
}
