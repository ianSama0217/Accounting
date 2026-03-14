package com.example.accounting.controller;

import com.example.accounting.Vo.BasicRes;
import com.example.accounting.entity.Record;
import com.example.accounting.service.RecordService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("record")
public class RecordController {
    @Resource
    private RecordService recordsService;

    @PostMapping
    public BasicRes<Void> create(@RequestBody Record record){
        return recordsService.create(record);
    }

    @DeleteMapping("/{recordId}")
    public BasicRes<Void> delete(@PathVariable int recordId){
        return recordsService.delete(recordId);
    }

    @GetMapping("/{recordId}")
    public BasicRes<Record> getById(@PathVariable int recordId){
        return recordsService.getById(recordId);
    }

    @GetMapping("/user/{userId}")
    public BasicRes<List<Record>> getByUserId(@PathVariable int userId){
        return recordsService.getByUserId(userId);
    }
    @GetMapping("/account/{accountId}")
    public BasicRes<List<Record>> getByAccountId(@PathVariable int accountId){
        return recordsService.getByAccountId(accountId);
    }

    @GetMapping("/category/{categoryId}")
    public BasicRes<List<Record>> getByCategoryId(@PathVariable int categoryId){
        return recordsService.getByCategoryId(categoryId);
    }
}
