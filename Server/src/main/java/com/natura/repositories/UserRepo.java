package com.natura.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.natura.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {
    public User findByEmail(String e);
}
