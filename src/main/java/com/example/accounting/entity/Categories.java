package com.example.accounting.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "categories")
@Getter
@Setter
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @JsonProperty("user_id")
    @Column(name = "user_id", nullable = false)
    private int userId;

    @Column(name = "name", length = 30, nullable = false)
    private String name;

    @Column(name = "type", nullable = false)
    private int type;

    public Categories() {
    }
}
