package com.example.accounting.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter
@Setter
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "username", length = 60, nullable = false, unique = true)
    private String username;

    @Column(name = "password", length = 60, nullable = false)
    private String password;

    @Column(name = "role", length = 10, nullable = false)
    private String role = "ROLE_USER";

    @Column(name = "create_at")
    private LocalDateTime createAt;

    public Users() {
    }
}
