package com.rafaelscarpelli.todo_list.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafaelscarpelli.todo_list.model.Tag;
import com.rafaelscarpelli.todo_list.model.User;

public interface TagRepository extends JpaRepository<Tag, Long> {
    List<Tag> findByUser(User user);
    Optional<Tag> findByIdAndUser(Long id, User user);
}
