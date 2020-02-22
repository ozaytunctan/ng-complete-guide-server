package com.ozaytunctan.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;

import javax.annotation.PostConstruct;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Configuration
public class CustomConfiguration {

	@PostConstruct
	public void init() {
		LocaleContextHolder.setLocale(Locale.forLanguageTag("tr"));
	}

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:i18n/messages");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}

	@Bean
	public FilterRegistrationBean<CorsFilter> corsFilter() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		final CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
		config.setAllowedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Auth"));
		config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "OPTIONS", "DELETE", "PATCH"));
		source.registerCorsConfiguration("/**", config);
		FilterRegistrationBean<CorsFilter> registration = new FilterRegistrationBean<CorsFilter>(
				new CorsFilter(source));
		return registration;
	}

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		org.modelmapper.config.Configuration config = modelMapper.getConfiguration();
		config.setMatchingStrategy(MatchingStrategies.STANDARD);
		config.setFieldAccessLevel(AccessLevel.PRIVATE);
		config.setFieldMatchingEnabled(true);
		config.setSkipNullEnabled(true);
		return modelMapper;
	}
	
	@Bean
	public  ObjectMapper objectMapper() {
		
		ObjectMapper objectMapper =new ObjectMapper();
	    objectMapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		//objectMapper.configure(SerializationFeature.FAIL_ON_SELF_REFERENCES, false);
		//objectMapper.configure(SerializationFeature.WRITE_ENUM_KEYS_USING_INDEX, true);
	   return objectMapper;
	   
		
	}

}
