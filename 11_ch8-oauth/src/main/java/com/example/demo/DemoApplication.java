package com.example.demo;

import com.example.demo.data.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	ApplicationRunner dataLoader(UserRepository repo, PasswordEncoder  encoder) {
		return args -> {
			repo.save(
					new User("habuma", encoder.encode("password"), "ROLE_ADMIN"));
			repo.save(
					new User("tacochef", encoder.encode("password"), "ROLE_ADMIN"));
		};
	}
}
