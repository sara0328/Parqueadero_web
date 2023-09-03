package com.example.Parqueadero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.parqueadero")
public class ParqueaderoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParqueaderoApplication.class, args);
    }
}
