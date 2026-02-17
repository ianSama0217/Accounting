package com.example.accounting.dao;

import com.example.accounting.entity.Records;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordsDao extends JpaRepository<Records, Integer> {
    public List<Records> findByUserId(int userId);

    public List<Records> findByAccountId(int accountId);

    public List<Records> findByCategoryId(int categoryId);
}
