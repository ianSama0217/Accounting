package com.example.accounting.dao;

import com.example.accounting.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryDao extends JpaRepository<Category, Integer> {
    public List<Category> findByUserId(int userId);
}
