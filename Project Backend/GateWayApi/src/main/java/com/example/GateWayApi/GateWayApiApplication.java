package com.example.GateWayApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GateWayApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GateWayApiApplication.class, args);
	}

}
