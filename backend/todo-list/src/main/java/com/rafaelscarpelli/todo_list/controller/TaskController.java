package com.rafaelscarpelli.todo_list.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.rafaelscarpelli.todo_list.model.Task;
import com.rafaelscarpelli.todo_list.model.User;
import com.rafaelscarpelli.todo_list.service.TaskService;
import com.rafaelscarpelli.todo_list.service.UserService;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;
    private final UserService userService;

    public TaskController(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }

    private User getAuthenticatedUser(Principal principal) {
        return userService.getUserByEmail(principal.getName());
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks(Principal principal) {
        return ResponseEntity.ok(taskService.getTasksByUser(getAuthenticatedUser(principal)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id, Principal principal) {
        return ResponseEntity.ok(taskService.getTaskByIdAndUser(id, getAuthenticatedUser(principal)));
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task, Principal principal) {
        return ResponseEntity.ok(taskService.createTask(task, getAuthenticatedUser(principal)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task, Principal principal) {
        return ResponseEntity.ok(taskService.updateTask(id, task, getAuthenticatedUser(principal)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id, Principal principal) {
        taskService.deleteTask(id, getAuthenticatedUser(principal));
        return ResponseEntity.noContent().build();
    }
}
