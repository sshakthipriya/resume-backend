package com.hackathon.ebooks.inventoryservice.service;

import com.hackathon.ebooks.inventoryservice.model.User;
import com.hackathon.ebooks.inventoryservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String findUserById (Long id){
      return this.userRepository.findUserByUserId(id).getUserName();
    }

    public User findUserByEmail(String email){
        return this.userRepository.findUserByUserEmail(email);
    }
}
