package com.bekov.currency_database_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
public class CurrencyDatabaseServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurrencyDatabaseServerApplication.class, args);
    }

}
