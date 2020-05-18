package com.example.todoApp.controllers;


import com.example.todoApp.DTOs.TodoItemDTO;
import com.example.todoApp.services.interfaces.TodoServiceInterface;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TodoControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private TodoServiceInterface todoService;

    @Test
    @DisplayName("crate todo item")
    @Transactional
    void createTodoItem() throws Exception {
        long todoItemId = 1;
        Instant cratedOn = Instant.now();

        TodoItemDTO expectedTodoItem = new TodoItemDTO(todoItemId, "String", cratedOn, null, false, null);
        todoService.create(expectedTodoItem);

        mvc.perform(get("/api/todo/todo/{0}", todoItemId)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.text", is(expectedTodoItem.getText())))
                .andExpect(jsonPath("$.createdOn", is(expectedTodoItem.getCreatedOn().toString())))
                .andExpect(jsonPath("$.updatedOn", is(expectedTodoItem.getUpdatedOn())))
                .andExpect(jsonPath("$.completed", is(expectedTodoItem.isCompleted())));
    }

    @Test
    @DisplayName("get todo list")
    @Transactional
    void getTodoList() throws Exception {
        int todoItemsSize = 10;

        for (int i = 1; i <= 10; i++) {
            todoService.create(new TodoItemDTO(i, "String", Instant.now(), null, false, null));
        }

        mvc.perform(get("/api/todo/todo-list")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(todoItemsSize)));
    }
}