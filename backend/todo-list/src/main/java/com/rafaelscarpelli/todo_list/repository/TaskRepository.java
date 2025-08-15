package com.rafaelscarpelli.todo_list.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafaelscarpelli.todo_list.model.Task;
import com.rafaelscarpelli.todo_list.model.User;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUser(User user);
    Optional<Task> findByIdAndUser(Long id, User user);
}
