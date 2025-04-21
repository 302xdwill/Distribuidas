package com.upeu.msregistryserve;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MsRegistryServeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsRegistryServeApplication.class, args);
	}

}
