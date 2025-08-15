package com.rafaelscarpelli.todo_list.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.rafaelscarpelli.todo_list.model.Tag;
import com.rafaelscarpelli.todo_list.model.User;
import com.rafaelscarpelli.todo_list.service.TagService;
import com.rafaelscarpelli.todo_list.service.UserService;

@RestController
@RequestMapping("/api/tags")
public class TagController {

    private final TagService tagService;
    private final UserService userService;

    public TagController(TagService tagService, UserService userService) {
        this.tagService = tagService;
        this.userService = userService;
    }

    private User getAuthenticatedUser(Principal principal) {
        return userService.getUserByEmail(principal.getName());
    }

    @GetMapping
    public ResponseEntity<List<Tag>> getAllTags(Principal principal) {
        return ResponseEntity.ok(tagService.getTagsByUser(getAuthenticatedUser(principal)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tag> getTagById(@PathVariable Long id, Principal principal) {
        return ResponseEntity.ok(tagService.getTagByIdAndUser(id, getAuthenticatedUser(principal)));
    }

    @PostMapping
    public ResponseEntity<Tag> createTag(@RequestBody Tag tag, Principal principal) {
        return ResponseEntity.ok(tagService.createTag(tag, getAuthenticatedUser(principal)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tag> updateTag(@PathVariable Long id, @RequestBody Tag tag, Principal principal) {
        return ResponseEntity.ok(tagService.updateTag(id, tag, getAuthenticatedUser(principal)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTag(@PathVariable Long id, Principal principal) {
        tagService.deleteTag(id, getAuthenticatedUser(principal));
        return ResponseEntity.noContent().build();
    }
}
