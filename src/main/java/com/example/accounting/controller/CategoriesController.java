package com.example.accounting.controller;

import com.example.accounting.Vo.BasicRes;
import com.example.accounting.entity.Categories;
import com.example.accounting.service.CategoriesService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoriesController {
    @Resource
    private CategoriesService categoriesService;

    @PostMapping
    public BasicRes<Void> create(@RequestBody Categories categories){
       return categoriesService.create(categories);
    }

    @DeleteMapping("/{categoryId}")
    public BasicRes<Void> delete(@PathVariable int categoryId){
        return categoriesService.delete(categoryId);
    }

    @GetMapping("/user/{userId}")
    public BasicRes<List<Categories>> getByUserId(@PathVariable int userId){
        return categoriesService.getByUserId(userId);
    }
}
