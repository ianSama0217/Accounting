package com.example.accounting.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "accounts")
@Getter
@Setter
public class Accounts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @JsonProperty("user_id")
    @Column(name = "user_id", nullable = false)
    private int userId;

    @Column(name = "name", length = 60)
    private String name;

    @Column(name = "balance")
    private int balance = 0;

    public Accounts() {
    }
}
