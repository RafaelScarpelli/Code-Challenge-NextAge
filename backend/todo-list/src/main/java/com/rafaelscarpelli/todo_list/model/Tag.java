package com.rafaelscarpelli.todo_list.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "tags")
@Data
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 50)
    private String name;

    @ManyToMany(mappedBy = "tags")
    @ToString.Exclude
    private List<Task> tasks;

    public void addTask(Task task) {
        tasks.add(task);
        task.getTags().add(this);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
        task.getTags().remove(this);
    }
}