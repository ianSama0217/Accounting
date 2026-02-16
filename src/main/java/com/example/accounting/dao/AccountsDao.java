package com.example.accounting.dao;

import com.example.accounting.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountsDao extends JpaRepository<Accounts, Integer> {
    public List<Accounts> findByUserId(int userId);
}
