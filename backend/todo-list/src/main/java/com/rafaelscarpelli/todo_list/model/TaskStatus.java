package com.rafaelscarpelli.todo_list.model;

import lombok.Getter;

@Getter
public enum TaskStatus {
    PENDING,
    COMPLETED;
    
    public boolean isCompleted() {
        return this == COMPLETED;
    }
}