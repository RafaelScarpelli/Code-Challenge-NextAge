package com.rafaelscarpelli.todo_list.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "reminders")
@Data
public class Reminder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDateTime reminderTime;

    @ManyToOne
    @JoinColumn(name = "task_id")
    @NotNull
    private Task task;

    public boolean isDue() {
        return reminderTime != null && reminderTime.isBefore(LocalDateTime.now());
    }
}