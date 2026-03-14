package com.example.accounting.controller;

import com.example.accounting.Vo.BasicRes;
import com.example.accounting.Vo.LoginReq;
import com.example.accounting.Vo.UserRes;
import com.example.accounting.entity.User;
import com.example.accounting.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {
    @Resource
    private UserService usersService;

    @PostMapping("/register")
    public BasicRes<Void> register(@RequestBody User user){
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
