package com.example.todoApp.configuration;

import com.example.todoApp.services.TodoService;
import com.example.todoApp.services.interfaces.TodoServiceInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public TodoServiceInterface todoService(){
        return new TodoService();
    }

}
