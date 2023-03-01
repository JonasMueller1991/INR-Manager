package com.inr.inrmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EntityScan(basePackages = {"com.inr.inrmanager.jpa.model"})
public class InrManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(InrManagerApplication.class, args);
    }

}
