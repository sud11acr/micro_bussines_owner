package com.project.micro.businnesowners;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class BusinnesownersApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusinnesownersApplication.class, args);
	}

}
