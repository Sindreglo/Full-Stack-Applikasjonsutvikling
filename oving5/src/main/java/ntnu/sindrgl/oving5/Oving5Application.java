package ntnu.sindrgl.oving5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Oving5Application {

	public static void main(String[] args) {
		SpringApplication.run(Oving5Application.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/calculate")
						.allowedMethods("GET", "POST")
						.allowedOrigins("http://localhost:3000");
				registry.addMapping("/api/addExpression")
						.allowedMethods("GET", "POST")
						.allowedOrigins("http://localhost:3000");
			}
		};
	}

}
