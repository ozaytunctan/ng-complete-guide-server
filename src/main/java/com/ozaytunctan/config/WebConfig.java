package com.ozaytunctan.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// registry
		// .addMapping("**/Services/rest/api/v1/**")
		// .allowedOrigins("http://localhost:4200")
		// .allowedMethods("POST","GET","PUT", "DELETE","PATCH");
	}

}