package com.youpri.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Youpri1Application {

	public static void main(String[] args) {
		SpringApplication.run(Youpri1Application.class, args);
	}

}
