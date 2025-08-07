package com.rafaelscarpelli.todo_list.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "tags")
@Data
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 1, max = 50)
    @Column(unique = true)
    private String name;

    @Column(nullable = false)
    private boolean isDefault = false;

    @OneToMany(mappedBy = "tag", fetch = FetchType.LAZY)
    private List<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        tasks.add(task);
        task.setTag(this);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
        // sem task.setTag(null), pois violaria @NotNull
        // será tratada no serviçe
    }
}