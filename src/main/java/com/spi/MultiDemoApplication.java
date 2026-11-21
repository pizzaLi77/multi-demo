package com.spi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class MultiDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultiDemoApplication.class, args);
    }

}
