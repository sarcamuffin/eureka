package com.example.demostudent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@RefreshScope
public class DemostudentApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemostudentApplication.class, args);
    }

}
