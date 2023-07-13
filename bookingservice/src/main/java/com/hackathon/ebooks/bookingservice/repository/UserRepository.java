package com.hackathon.ebooks.bookingservice.repository;

import com.hackathon.ebooks.bookingservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Long> {
    User findUserByUserEmail(String email);
}
