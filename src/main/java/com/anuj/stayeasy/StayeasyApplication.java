package com.anuj.stayeasy;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.anuj.stayeasy.entity.User;
import com.anuj.stayeasy.service.UserService;

@SpringBootApplication
public class StayeasyApplication {

	public static void main(String[] args) {
		SpringApplication.run(StayeasyApplication.class, args);

	}

// 	@Bean
// 	CommandLineRunner test(UserService userService) {

// 		return args -> {
// 			User user = new User();

// 			user.setFullName("Anuj S");
// 			user.setEmail("anuj123@gmail.com");
// 			user.setPassword("123654");

// 			User savedUser = userService.register(user);

// 			System.out.println(savedUser);
// 		};
// 	}

}
