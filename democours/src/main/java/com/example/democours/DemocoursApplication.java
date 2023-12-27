package com.example.democours;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@RefreshScope
public class DemocoursApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemocoursApplication.class, args);
	}

}
