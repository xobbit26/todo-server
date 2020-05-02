package com.example.todoApp.DAL.repository;

import com.example.todoApp.DAL.model.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {
    Optional<TodoItem> findById(long id);
}
