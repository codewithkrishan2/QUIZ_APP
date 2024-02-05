package com.kksg.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class QuizAppServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizAppServiceRegistryApplication.class, args);
	}

}
