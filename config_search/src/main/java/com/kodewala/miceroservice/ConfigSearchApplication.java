package com.kodewala.miceroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigSearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigSearchApplication.class, args);
	}

}
