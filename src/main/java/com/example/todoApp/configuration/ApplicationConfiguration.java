package com.example.todoApp.configuration;

import com.example.todoApp.DAL.TodoStaticContext;
import com.example.todoApp.DAL.interfaces.TodoContextInterface;
import com.example.todoApp.services.TodoService;
import com.example.todoApp.services.interfaces.TodoServiceInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public TodoContextInterface todoContext() {
        return new TodoStaticContext();
    }

    @Bean
    public TodoServiceInterface todoService(TodoContextInterface todoContext) {
        return new TodoService(todoContext);
    }

}
