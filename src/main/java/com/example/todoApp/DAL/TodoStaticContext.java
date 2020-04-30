package com.example.todoApp.DAL;

import com.example.todoApp.DAL.interfaces.TodoContextInterface;
import com.example.todoApp.DTOs.TodoItemDTO;
import com.example.todoApp.exceptions.TodoItemNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TodoStaticContext implements TodoContextInterface {

    private static List<TodoItemDTO> todoItemsStaticStore = new ArrayList<>();

    @Override
    public void create(TodoItemDTO todoItem) {
        long id = todoItemsStaticStore.isEmpty() ? 1 : todoItemsStaticStore.size() + 1;
        todoItem.setId(id);

        todoItemsStaticStore.add(todoItem);
    }

    @Override
    public TodoItemDTO getById(long id) {
        Optional<TodoItemDTO> todoItemOpt = getTodoItemById(id);
        return todoItemOpt.orElse(null);
    }

    @Override
    public List<TodoItemDTO> getTodoList() {
        return todoItemsStaticStore;
    }

    @Override
    public TodoItemDTO update(long id, TodoItemDTO todoItem) {
        Optional<TodoItemDTO> todoItemOpt = getTodoItemById(id);

        if (todoItemOpt.isEmpty()) {
            throw new TodoItemNotFoundException(String.format("There isn't such element with id %d", id));
        }

        TodoItemDTO itemToUpdate = todoItemOpt.get();
        itemToUpdate.setText(todoItem.getText());
        itemToUpdate.setCreatedOn(todoItem.getCreatedOn());

        return itemToUpdate;
    }

    @Override
    public void delete(long id) {
        Optional<TodoItemDTO> todoItemOpt = getTodoItemById(id);
        if(todoItemOpt.isEmpty()){
            throw new TodoItemNotFoundException(String.format("There isn't such element with id %d", id));
        }

        todoItemsStaticStore.remove(todoItemOpt.get());
    }

    private Optional<TodoItemDTO> getTodoItemById(long id){
        return todoItemsStaticStore
                .stream()
                .filter(x -> x.getId() == id)
                .findFirst();
    }
}
