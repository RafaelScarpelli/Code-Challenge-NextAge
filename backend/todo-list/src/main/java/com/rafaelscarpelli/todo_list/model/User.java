package com.rafaelscarpelli.todo_list.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 100)
    private String name;

    @Email
    @NotBlank
    @Column(unique = true, nullable = false)
    private String email;

    @NotBlank
    @Size(min = 8)
    @Column(nullable = false)
    private String password;

    private String resetPasswordToken;

    private LocalDateTime resetPasswordExpires;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Task> tasks = new ArrayList<>();

    public void generateResetPasswordToken() {
        this.resetPasswordToken = UUID.randomUUID().toString();
        this.resetPasswordExpires = LocalDateTime.now().plusHours(24);
    }

    public boolean isResetTokenValid() {
        return resetPasswordToken != null && resetPasswordExpires != null &&
                resetPasswordExpires.isAfter(LocalDateTime.now());
    }

    public void clearResetPasswordToken() {
        this.resetPasswordToken = null;
        this.resetPasswordExpires = null;
    }
}