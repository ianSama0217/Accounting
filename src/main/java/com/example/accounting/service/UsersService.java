package com.example.accounting.service;

import com.example.accounting.Vo.BasicRes;
import com.example.accounting.Vo.LoginReq;
import com.example.accounting.Vo.UserRes;
import com.example.accounting.entity.Users;

public interface UsersService {
    public BasicRes<Void> register(Users user);

    public BasicRes<Void> login(LoginReq req);

    public BasicRes<UserRes> getById(int userId);
}
