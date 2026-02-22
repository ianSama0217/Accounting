package com.example.accounting.controller;

import com.example.accounting.Vo.BasicRes;
import com.example.accounting.Vo.LoginReq;
import com.example.accounting.Vo.UserRes;
import com.example.accounting.entity.Users;
import com.example.accounting.service.UsersService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UsersController {
    @Resource
    private UsersService usersService;

    @PostMapping("/register")
    public BasicRes<Void> register(@RequestBody Users user){
        return usersService.register(user);
    }

    @PostMapping("/login")
    public BasicRes<Void> login(@RequestBody LoginReq req){
        return usersService.login(req);
    }

    @GetMapping("/{userId}")
    public BasicRes<UserRes> getById(@PathVariable int userId){
        return  usersService.getById(userId);
    }
}
