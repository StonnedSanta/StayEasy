package com.anuj.stayeasy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anuj.stayeasy.dto.request.LoginUserRequest;
import com.anuj.stayeasy.dto.request.RegisterUserRequest;
import com.anuj.stayeasy.dto.response.LoginUserResponse;
import com.anuj.stayeasy.dto.response.RegisterUserResponse;
import com.anuj.stayeasy.entity.User;
import com.anuj.stayeasy.service.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public RegisterUserResponse register(@Valid @RequestBody RegisterUserRequest request) {
        User user  = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        
        User savedUser = userService.register(user);

        RegisterUserResponse response = new RegisterUserResponse();
        response.setId(savedUser.getId());
        response.setName(savedUser.getName());
        response.setEmail(savedUser.getEmail());
        response.setMessage("Registration Successful");

        return response;
    }

    @PostMapping("/login")
    public LoginUserResponse login(@RequestBody LoginUserRequest request) {

        User user = userService.login(request);

        if (user == null) {
            return null;
        }

        LoginUserResponse response = new LoginUserResponse();

        response.setId(user.getId());
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        response.setRole(user.getRole().name());
        response.setMessage("Login Successful");

        return response;
    }
   
}
