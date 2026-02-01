package com.example.accounting.dao;

import com.example.accounting.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsDao extends JpaRepository<Accounts, Integer> {
}
