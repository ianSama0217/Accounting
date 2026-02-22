package com.example.accounting.Vo;

import lombok.Getter;

@Getter
public class LoginReq {
    private final String username;

    private final String password;

    public LoginReq(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
