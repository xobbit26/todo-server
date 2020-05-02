package com.example.todoApp.DTOs;

import java.time.Instant;

public class TodoItemDTO {
    private final long id;
    private final String text;
    private final Instant createdOn;
    private final Instant updatedOn;
    private final boolean isCompleted;
    private final Instant completedOn;

    public TodoItemDTO(long id, String text, Instant createdOn, Instant updatedOn, boolean isCompleted, Instant completedOn) {
        this.id = id;
        this.text = text;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
        this.isCompleted = isCompleted;
        this.completedOn = completedOn;
    }

    public long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public Instant getCreatedOn() {
        return createdOn;
    }

    public Instant getUpdatedOn() {
        return updatedOn;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public Instant getCompletedOn() {
        return completedOn;
    }

}
