package edu.ntnu.idatt2105.sindrgl.oving4_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class CalculatorBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculatorBackendApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/calculation")
						.allowedMethods("GET", "POST")
						.allowedOrigins("http://localhost:3000");
			}
		};
	}
}
