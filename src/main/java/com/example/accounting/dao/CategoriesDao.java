package com.example.accounting.dao;

import com.example.accounting.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesDao extends JpaRepository<Categories, Integer> {
}
