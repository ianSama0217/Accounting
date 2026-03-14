package com.example.accounting.dao;

import com.example.accounting.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountDao extends JpaRepository<Account, Integer> {
    public List<Account> findByUserId(int userId);
}
