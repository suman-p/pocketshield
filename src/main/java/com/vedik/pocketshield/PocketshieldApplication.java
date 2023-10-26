package com.vedik.pocketshield;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//http://localhost:8180/realms/pocketshield/.well-known/openid-configuration

@SpringBootApplication
public class PocketshieldApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocketshieldApplication.class, args);
	}

}
