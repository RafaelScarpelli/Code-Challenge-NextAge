package com.rafaelscarpelli.todo_list.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rafaelscarpelli.todo_list.model.Task;
import com.rafaelscarpelli.todo_list.model.User;
import com.rafaelscarpelli.todo_list.repository.TaskRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTasksByUser(User user) {
        return taskRepository.findByUser(user);
    }

    public Task getTaskByIdAndUser(Long id, User user) {
        return taskRepository.findByIdAndUser(id, user)
                .orElseThrow(() -> new EntityNotFoundException("Task não encontrada"));
    }

    @Transactional
    public Task createTask(Task task, User user) {
        task.setUser(user);
        return taskRepository.save(task);
    }

    @Transactional
    public Task updateTask(Long id, Task updatedTask, User user) {
        Task existingTask = getTaskByIdAndUser(id, user);
        existingTask.setTitle(updatedTask.getTitle());
        existingTask.setDescription(updatedTask.getDescription());
        existingTask.setStatus(updatedTask.getStatus());
        existingTask.setPriority(updatedTask.getPriority());
        existingTask.setDueDate(updatedTask.getDueDate());
        existingTask.setTag(updatedTask.getTag());
        return taskRepository.save(existingTask);
    }

    @Transactional
    public void deleteTask(Long id, User user) {
        Task task = getTaskByIdAndUser(id, user);
        taskRepository.delete(task);
    }
}
