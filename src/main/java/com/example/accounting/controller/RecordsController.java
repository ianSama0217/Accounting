package com.example.accounting.controller;

import com.example.accounting.Vo.BasicRes;
import com.example.accounting.entity.Records;
import com.example.accounting.service.RecordsService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("record")
public class RecordsController {
    @Resource
    private RecordsService recordsService;

    @PostMapping
    public BasicRes<Void> create(@RequestBody Records record){
        return recordsService.create(record);
    }

    @DeleteMapping("/{recordId}")
    public BasicRes<Void> delete(@PathVariable int recordId){
        return recordsService.delete(recordId);
    }

    @GetMapping("/{recordId}")
    public BasicRes<Records> getById(@PathVariable int recordId){
        return recordsService.getById(recordId);
    }

    @GetMapping("/user/{userId}")
    public BasicRes<List<Records>> getByUserId(@PathVariable int userId){
        return recordsService.getByUserId(userId);
    }
    @GetMapping("/account/{accountId}")
    public BasicRes<List<Records>> getByAccountId(@PathVariable int accountId){
        return recordsService.getByAccountId(accountId);
    }

    @GetMapping("/category/{categoryId}")
    public BasicRes<List<Records>> getByCategoryId(@PathVariable int categoryId){
        return recordsService.getByCategoryId(categoryId);
    }
}
