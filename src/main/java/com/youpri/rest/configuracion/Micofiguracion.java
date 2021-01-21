package com.youpri.rest.configuracion;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Micofiguracion {
	@Bean
	public ModelMapper modelMapper() {
	 return new ModelMapper();
	}
}
