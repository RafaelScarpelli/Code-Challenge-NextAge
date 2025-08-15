package com.rafaelscarpelli.todo_list.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rafaelscarpelli.todo_list.model.Tag;
import com.rafaelscarpelli.todo_list.model.User;
import com.rafaelscarpelli.todo_list.repository.TagRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TagService {

    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public List<Tag> getTagsByUser(User user) {
        return tagRepository.findByUser(user);
    }

    public Tag getTagByIdAndUser(Long id, User user) {
        return tagRepository.findByIdAndUser(id, user)
                .orElseThrow(() -> new EntityNotFoundException("Tag não encontrada"));
    }

    @Transactional
    public Tag createTag(Tag tag, User user) {
        tag.setUser(user);
        return tagRepository.save(tag);
    }

    @Transactional
    public Tag updateTag(Long id, Tag updatedTag, User user) {
        Tag existingTag = getTagByIdAndUser(id, user);
        existingTag.setName(updatedTag.getName());
        existingTag.setDefault(updatedTag.isDefault());
        return tagRepository.save(existingTag);
    }

    @Transactional
    public void deleteTag(Long id, User user) {
        Tag tag = getTagByIdAndUser(id, user);
        tagRepository.delete(tag);
    }
}
