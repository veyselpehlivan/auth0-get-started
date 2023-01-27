package com.kloia.authodemo;

import com.kloia.authodemo.lookup.Domain;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class AuthoDemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AuthoDemoApplication.class, args);
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Override
    public void run(String... args) throws Exception {
        Domain.putToDomainMap("kloia.com", "http://localhost:8081");
        Domain.putToDomainMap("buildops.com", "http://localhost:8082");
    }
}
