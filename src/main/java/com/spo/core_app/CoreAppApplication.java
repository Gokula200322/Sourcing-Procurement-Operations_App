package com.spo.core_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class CoreAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreAppApplication.class, args);
	}
	// adding this line to check if the changes reflect in this atsk1 branch and
	// whether im able to create a pull request on main.go
}
