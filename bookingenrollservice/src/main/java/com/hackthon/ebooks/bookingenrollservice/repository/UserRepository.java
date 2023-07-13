package com.hackthon.ebooks.bookingenrollservice.repository;


import com.hackthon.ebooks.bookingenrollservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Long> {
    User findUserByUserEmail(String email);
}
