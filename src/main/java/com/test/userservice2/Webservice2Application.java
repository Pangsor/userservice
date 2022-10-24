package com.test.userservice2;

import com.test.userservice2.domain.User;
import com.test.userservice2.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class Webservice2Application {

	public static void main(String[] args) {
		SpringApplication.run(Webservice2Application.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run (UserService userService){
		return args -> {
			userService.saveUser(new User(null, "fulan","1234"));
			userService.saveUser(new User(null, "valen","1234"));
		};
	}
}
