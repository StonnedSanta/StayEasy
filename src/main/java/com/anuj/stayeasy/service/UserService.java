package com.anuj.stayeasy.service;

import com.anuj.stayeasy.repository.BookingRepository;

import java.util.Optional;

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
     
     public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
     }

     // create
     public User register(User user) {

      // email
      String email = user.getEmail();
      Optional<User> existingUser = userRepository.findByEmail(email);
      if(existingUser.isPresent()) {
         System.out.println("Email alredy exists");
         return null;
      }
        
      // assign default role
      user.setRole(Role.CUSTOMER);

      // save user
      return userRepository.save(user);

   }

}
