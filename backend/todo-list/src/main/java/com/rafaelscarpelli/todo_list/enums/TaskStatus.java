package com.rafaelscarpelli.todo_list.enums;

import lombok.Getter;

@Getter
public enum TaskStatus {
    PENDING,
    COMPLETED;

    public boolean isCompleted() {
        return this == COMPLETED;
    }
}
