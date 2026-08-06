package com.anuj.stayeasy.service;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.anuj.stayeasy.entity.User;
import com.anuj.stayeasy.enums.Role;
import com.anuj.stayeasy.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User register(User user) {

        String email = user.getEmail();

        Optional<User> existingUser = userRepository.findByEmail(email);

        if (existingUser.isPresent()) {
            System.out.println("Email already exists");
            return null;
        }

        // Assign default role
        user.setRole(Role.CUSTOMER);

        // Encrypt password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Save user
        return userRepository.save(user);
    }
}