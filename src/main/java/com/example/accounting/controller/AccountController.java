package com.example.accounting.controller;

import com.example.accounting.Vo.BasicRes;
import com.example.accounting.entity.Account;
import com.example.accounting.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("account")
public class AccountController {
    @Resource
    private AccountService accountsService;

    @PostMapping
    public BasicRes<Void> create(@RequestBody Account account) {
        return accountsService.create(account);
    }

    @DeleteMapping("/{accountId}")
    public BasicRes<Void> delete(@PathVariable int accountId) {
        return accountsService.delete(accountId);
    }

    @GetMapping("/{accountId}")
    public BasicRes<Account> getById(@PathVariable int accountId) {
        return accountsService.getById(accountId);
    }

    @GetMapping("/user/{userId}")
    public BasicRes<List<Account>> getByUserId(@PathVariable int userId) {
        return accountsService.getByUserId(userId);
    }
}
