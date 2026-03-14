package com.example.accounting.dao;

import com.example.accounting.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
    public boolean existsByUsername(String username);

    public User findByUsername(String username);
}
