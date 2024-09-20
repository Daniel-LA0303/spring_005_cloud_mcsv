package com.mx.mcsv.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class McsvUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(McsvUserApplication.class, args);
	}

}
