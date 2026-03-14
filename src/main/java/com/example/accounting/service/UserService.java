package com.example.accounting.service;

import com.example.accounting.Vo.BasicRes;
import com.example.accounting.Vo.LoginReq;
import com.example.accounting.Vo.UserRes;
import com.example.accounting.entity.User;

public interface UserService {
    public BasicRes<Void> register(User user);

    public BasicRes<Void> login(LoginReq req);

    public BasicRes<UserRes> getById(int userId);
}
