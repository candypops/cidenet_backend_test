package com.cidenet.cidenet.model;

import com.cidenet.cidenet.repository.WorkFieldRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class WorkFieldConfig {
    @Bean
    CommandLineRunner commandLineRunner(WorkFieldRepository repository) {
        return args -> {
            WorkField admin = new WorkField(
                    "ADMINISTRACION",
                    "ACTIVE");
            WorkField finance = new WorkField(
                    "FINANCIERA",
                    "ACTIVE");
            WorkField sales = new WorkField(
                    "COMPRAS",
                    "ACTIVE");
            WorkField infrastructure = new WorkField(
                    "INFRAESTRUCTURA",
                    "ACTIVE");
            WorkField operations = new WorkField(
                    "OPERACION",
                    "ACTIVE");
            WorkField humanResources = new WorkField(
                    "TALENTO HUMANO",
                    "ACTIVE");
            WorkField services = new WorkField(
                    "SERVICIOS VARIOS",
                    "ACTIVE");

            repository.saveAll(
                    List.of(admin, finance, sales, infrastructure, operations, humanResources, services)
            );
        };
    }

}
