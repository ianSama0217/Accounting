package com.example.accounting.dao;

import com.example.accounting.entity.Records;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordsDao extends JpaRepository<Records, Integer> {
}
