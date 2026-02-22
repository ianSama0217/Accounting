package com.example.accounting.Vo;

import com.example.accounting.entity.Users;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserRes {
    private final int id;

    private final String username;

    private final String role;

    @JsonProperty("create_at")
    private LocalDateTime createAt;

    public UserRes(Users user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.role = user.getRole();
        this.createAt = user.getCreateAt();
    }
}
