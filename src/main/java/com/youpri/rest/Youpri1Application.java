package com.youpri.rest;

import javax.sql.DataSource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.youpri.rest.service.subida.StorageService;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
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
	@Bean
    public DataSource dataSource(){
       DriverManagerDataSource dataSource = new DriverManagerDataSource();
       dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
       dataSource.setUrl("jdbc:mysql://localhost:3306/videosbd?serverTimezone=UTC");
       dataSource.setUsername("root");
       dataSource.setPassword("Elchupacabras123");
       return dataSource;
    }
}
