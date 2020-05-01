package com.example.todoApp.DTOs;

import java.time.Instant;

public class TodoItemDTO {
    private long id;
    private String text;
    private Instant createdOn;
    private boolean isCompleted;
    private Instant completedOn;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Instant getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Instant createdOn) {
        this.createdOn = createdOn;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public Instant getCompletedOn() {
        return completedOn;
    }

    public void setCompletedOn(Instant completedOn) {
        this.completedOn = completedOn;
    }

}
