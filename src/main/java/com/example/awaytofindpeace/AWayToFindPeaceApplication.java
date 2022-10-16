package com.example.awaytofindpeace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com")
@SpringBootApplication
public class AWayToFindPeaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AWayToFindPeaceApplication.class, args);
	}

}
