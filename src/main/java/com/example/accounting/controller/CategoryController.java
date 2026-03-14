package com.example.accounting.controller;

import com.example.accounting.Vo.BasicRes;
import com.example.accounting.entity.Category;
import com.example.accounting.service.CategoryService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {
    @Resource
    private CategoryService categoriesService;

    @PostMapping
    public BasicRes<Void> create(@RequestBody Category categories){
       return categoriesService.create(categories);
    }

    @DeleteMapping("/{categoryId}")
    public BasicRes<Void> delete(@PathVariable int categoryId){
        return categoriesService.delete(categoryId);
    }

    @GetMapping("/user/{userId}")
    public BasicRes<List<Category>> getByUserId(@PathVariable int userId){
        return categoriesService.getByUserId(userId);
    }
}
