package com.youpri.rest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.youpri.rest.service.subida.StorageService;

@SpringBootApplication
@EnableJpaAuditing
public class Youpri1Application {

	public static void main(String[] args) {
		SpringApplication.run(Youpri1Application.class, args);
	}
	@Bean
	public CommandLineRunner init(StorageService storageService) 
	{
		return args -> {
			storageService.deleteAll();
			storageService.init();
		};
	}
}
