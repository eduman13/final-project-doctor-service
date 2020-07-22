package com.ironhack.finalprojectdoctorservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class FinalProjectDoctorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalProjectDoctorServiceApplication.class, args);
	}

}
