package com.testfolder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testfolder.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String userName);
}