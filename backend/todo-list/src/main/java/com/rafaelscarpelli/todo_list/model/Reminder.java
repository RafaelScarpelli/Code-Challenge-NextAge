package com.rafaelscarpelli.todo_list.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "reminders")
@Data
public class Reminder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime reminderTime;

    @ManyToOne
    @JoinColumn(name = "task_id")
    @NotNull
    private Task task;

    @Column(nullable = false)
    private boolean isActive = true;
    
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public boolean isDue() {
        return isActive && reminderTime != null && reminderTime.isBefore(LocalDateTime.now());
    }
}