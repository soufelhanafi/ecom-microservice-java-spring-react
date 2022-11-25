package com.ecom.microservice.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EcomMicroserviceEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcomMicroserviceEurekaApplication.class, args);
	}

}
