package com.example.todoApp.services;

import com.example.todoApp.DAL.model.TodoItem;
import com.example.todoApp.DAL.repository.TodoItemRepository;
import com.example.todoApp.DTOs.TodoItemDTO;
import com.example.todoApp.exceptions.ValidationException;
import com.example.todoApp.services.interfaces.TodoServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

public class TodoService implements TodoServiceInterface {
    private final static String TODO_ITEM_NOT_FOUND = "couldn't find the todo item with id %s";

    @Autowired
    TodoItemRepository todoItemRepository;

    @Override
    public void create(TodoItemDTO todoItem) {
        validateModel(todoItem);

        TodoItem todoItemEntity = new TodoItem();
        todoItemEntity.setCreatedOn(todoItem.getCreatedOn() == null ? Instant.now() : todoItem.getCreatedOn());
        todoItemEntity.setText(todoItem.getText());
        todoItemEntity.setCompleted(false);

        todoItemRepository.save(todoItemEntity);
    }

    @Override
    public TodoItemDTO getById(long id) {
        TodoItem todoItemEntity = todoItemRepository.findById(id)
                .orElseThrow(() -> new ValidationException(String.format(TODO_ITEM_NOT_FOUND, id)));

        return mapTodoEntityToDTO(todoItemEntity);
    }

    @Override
    public List<TodoItemDTO> getTodoList() {
        return todoItemRepository.findAll()
                .stream()
                .map(this::mapTodoEntityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TodoItemDTO update(long id, TodoItemDTO todoItem) {
        validateModel(todoItem);
        TodoItem todoItemToUpdate = todoItemRepository.findById(id)
                .orElseThrow(() -> new ValidationException(String.format(TODO_ITEM_NOT_FOUND, id)));

        todoItemToUpdate.setText(todoItem.getText());
        todoItemToUpdate.setCompletedOn(todoItem.getCompletedOn());
        todoItemToUpdate.setCompleted(todoItem.isCompleted());
        todoItemToUpdate.setUpdatedOn(todoItem.getUpdatedOn());

        todoItemRepository.save(todoItemToUpdate);

        return mapTodoEntityToDTO(todoItemToUpdate);
    }

    @Override
    public void delete(long id) {
        TodoItem todoItemToDelete = todoItemRepository.findById(id)
                .orElseThrow(() -> new ValidationException(String.format(TODO_ITEM_NOT_FOUND, id)));
        todoItemRepository.deleteById(todoItemToDelete.getId());
    }


    private void validateModel(TodoItemDTO todoItem) {
        if (todoItem == null) {
            throw new ValidationException("todo item is null");
        }
        if (StringUtils.isEmpty(todoItem.getText())) {
            throw new ValidationException("todo text is null or empty");
        }
    }

    private TodoItemDTO mapTodoEntityToDTO(TodoItem todoItemEntity) {
        return new TodoItemDTO(
                todoItemEntity.getId(),
                todoItemEntity.getText(),
                todoItemEntity.getCreatedOn(),
                todoItemEntity.getUpdatedOn(),
                todoItemEntity.isCompleted(),
                todoItemEntity.getCompletedOn()
        );
    }
}
