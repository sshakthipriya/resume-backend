package com.hackathon.ebooks.inventoryservice.repository;

import com.hackathon.ebooks.inventoryservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Long> {
    User findUserByUserId(Long id);
    User findUserByUserEmail(String email);
}
