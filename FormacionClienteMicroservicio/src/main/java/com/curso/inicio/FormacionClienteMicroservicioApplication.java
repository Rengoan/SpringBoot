package com.curso.inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Clase en la que se ejecuta el microservicio
 * 
 * @author sinensia Juan Luis España
 *
 */
@SpringBootApplication(scanBasePackages = { "com.curso.controller", "com.curso.service" })
public class FormacionClienteMicroservicioApplication {

	public static void main(String[] args) {
		// Inicia la aplicación Spring Boot.
		SpringApplication.run(FormacionClienteMicroservicioApplication.class, args);
	}

	/**
	 * Crea y devuelve una instancia de RestTemplate.
	 * 
	 * @return Instancia de RestTemplate.
	 */
	@Bean
	public RestTemplate getTemplate() {
		return new RestTemplate();
	}
}
