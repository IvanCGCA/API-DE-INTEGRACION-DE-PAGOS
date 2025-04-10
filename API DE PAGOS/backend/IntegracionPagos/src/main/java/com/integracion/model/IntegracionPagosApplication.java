package com.integracion.model;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan("com.integracion.model") // Escanea las entidades JPA
@EnableJpaRepositories("com.integracion.repository") // Escanea los repositorios
@ComponentScan({"com.integracion.controller","com.integracion.service"})
public class IntegracionPagosApplication {
    public static void main(String[] args) {
        SpringApplication.run(IntegracionPagosApplication.class, args);
    }
}