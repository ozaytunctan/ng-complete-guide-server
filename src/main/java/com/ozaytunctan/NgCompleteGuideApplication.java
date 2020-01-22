package com.ozaytunctan;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value="classpath:application-${Backend.env}.properties")
public class NgCompleteGuideApplication {

	@Value("${Backend.env}")
	private  String env;
	
	@PostConstruct
	public void init() {
		System.out.println("============>Application active profile:"+env+"<============");
	}
	public static void main(String[] args) {
	
		SpringApplication.run(NgCompleteGuideApplication.class, args);
		
	}

}
