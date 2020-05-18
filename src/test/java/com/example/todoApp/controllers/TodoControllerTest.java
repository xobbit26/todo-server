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

import java.time.Instant;

import static org.hamcrest.Matchers.is;
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
    void CreateTodoItem() throws Exception {
        long todoItemId = 1;
        Instant cratedOn = Instant.now();

        TodoItemDTO expectedTodoItem = new TodoItemDTO(todoItemId, "String", cratedOn, null, false, null);
        todoService.create(expectedTodoItem);

        mvc.perform(get("/api/todo/todo/" + todoItemId)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is((int) expectedTodoItem.getId())))
                .andExpect(jsonPath("$.text", is(expectedTodoItem.getText())))
                .andExpect(jsonPath("$.createdOn", is(expectedTodoItem.getCreatedOn().toString())))
                .andExpect(jsonPath("$.updatedOn", is(expectedTodoItem.getUpdatedOn())))
                .andExpect(jsonPath("$.completed", is(expectedTodoItem.isCompleted())));
    }
}