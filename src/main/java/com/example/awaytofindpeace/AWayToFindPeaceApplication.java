package com.example.awaytofindpeace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com")
@SpringBootApplication
@EntityScan("com")
public class AWayToFindPeaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AWayToFindPeaceApplication.class, args);
	}

}
