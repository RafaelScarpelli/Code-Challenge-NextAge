package com.rafaelscarpelli.todo_list.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafaelscarpelli.todo_list.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByResetPasswordToken(String token);
    boolean existsByEmail(String email);
}
