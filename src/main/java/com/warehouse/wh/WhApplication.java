package com.warehouse.wh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"com.warehouse.wh.Entity"})
public class WhApplication {

    public static void main(String[] args) {
        SpringApplication.run(WhApplication.class, args);
    }


}
