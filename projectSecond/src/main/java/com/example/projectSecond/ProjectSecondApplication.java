package com.example.projectSecond;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectSecondApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectSecondApplication.class, args);
		System.out.println("Application is ready to view");
	}
	//http://localhost:8080/login
	//http://localhost:8080/home
	//http://localhost:8080/viewAllSoftwaresInfo
}
