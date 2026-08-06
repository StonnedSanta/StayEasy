package com.anuj.stayeasy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
