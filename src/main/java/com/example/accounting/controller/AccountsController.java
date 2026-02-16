package com.example.accounting.controller;

import com.example.accounting.Vo.BasicRes;
import com.example.accounting.entity.Accounts;
import com.example.accounting.service.AccountsService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("account")
public class AccountsController {
    @Resource
    private AccountsService accountsService;

    @PostMapping
    public BasicRes<Void> create(@RequestBody Accounts account) {
        return accountsService.create(account);
    }

    @DeleteMapping("/{accountId}")
    public BasicRes<Void> delete(@PathVariable int accountId) {
        return accountsService.delete(accountId);
    }

    @GetMapping("/{accountId}")
    public BasicRes<Accounts> getById(@PathVariable int accountId) {
        return accountsService.getById(accountId);
    }

    @GetMapping("/user/{userId}")
    public BasicRes<List<Accounts>> getByUserId(@PathVariable int userId) {
        return accountsService.getByUserId(userId);
    }
}
