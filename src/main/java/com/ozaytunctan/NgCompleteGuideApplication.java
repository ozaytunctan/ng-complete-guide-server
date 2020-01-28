package com.ozaytunctan;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value="classpath:application-${Backend.env}.properties")
public class NgCompleteGuideApplication {
	
	
	@Qualifier("ddMMyyyyHHmmss")
	@Autowired
	private String date;
	
	@PostConstruct
	public void init() {
		System.out.println("============>Application active profile:"+date+"<============");
	}
	public static void main(String[] args) {
	
		SpringApplication.run(NgCompleteGuideApplication.class, args);
		
	}

}
