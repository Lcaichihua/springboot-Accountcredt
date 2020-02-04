package com.cavetech.springboot.Accountcredt.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringbootAccountcredtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAccountcredtApplication.class, args);
	}

}
