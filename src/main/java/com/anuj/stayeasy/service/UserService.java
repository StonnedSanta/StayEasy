package com.anuj.stayeasy.service;

import com.anuj.stayeasy.repository.BookingRepository;
import org.springframework.stereotype.Service;

import com.anuj.stayeasy.entity.User;
import com.anuj.stayeasy.enums.Role;
import com.anuj.stayeasy.repository.UserRepository;

@Service
public class UserService {
     // add @Service annotation
     // add dependencies
     // implement constructor injection
     // CRUD operations

     private final UserRepository userRepository;
     
     public UserService(UserRepository userRepository, BookingRepository bookingRepository) {
        this.userRepository = userRepository;
     }

     // create
     public User register(User user) {
        
        // assign default role
        user.setRole(Role.CUSTOMER);

        // save user
        return userRepository.save(user);

     }

}
