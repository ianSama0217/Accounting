package com.example.accounting.dao;

import com.example.accounting.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersDao extends JpaRepository<Users, Integer> {
    public boolean existsByUsername(String username);

    public Users findByUsername(String username);
}
