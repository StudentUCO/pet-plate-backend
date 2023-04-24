package com.iot.petplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class PetPlateApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetPlateApplication.class, args);
	}

}
