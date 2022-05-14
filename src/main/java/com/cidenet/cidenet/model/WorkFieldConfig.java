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
                    "Administración"
            );
            WorkField finance = new WorkField(
                    "Financiera"
            );
            WorkField sales = new WorkField(
                    "Compras"
            );
            WorkField infrastructure = new WorkField(
                    "Infraestructura"
            );
            WorkField operations = new WorkField(
                    "Operación"
            );
            WorkField humanResources = new WorkField(
                    "Talento Humano"
            );
            WorkField services = new WorkField(
                    "Servicios Varios"
            );

            repository.saveAll(
                    List.of(admin, finance, sales, infrastructure, operations, humanResources, services)
            );
        };
    }

}
