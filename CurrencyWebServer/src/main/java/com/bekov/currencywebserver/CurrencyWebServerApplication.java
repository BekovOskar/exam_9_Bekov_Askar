package com.bekov.currencywebserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CurrencyWebServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurrencyWebServerApplication.class, args);
    }

}
