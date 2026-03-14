package com.example.accounting.dao;

import com.example.accounting.entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordDao extends JpaRepository<Record, Integer> {
    public List<Record> findByUserId(int userId);

    public List<Record> findByAccountId(int accountId);

    public List<Record> findByCategoryId(int categoryId);
}
