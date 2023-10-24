package com.moa.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@Configuration(proxyBeanMethods = false)
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}
	
	/*
	 * This is not recommended to do as it is a big security hole.
	 * However, it has been done due to pressing deadlines to ensure features work as intended.
	 */
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
	    @Override
	    public void addCorsMappings(final CorsRegistry registry) {
	    	registry.addMapping("/**").allowedMethods("*").allowedHeaders("*");
	    }
	        };
	    }
}
