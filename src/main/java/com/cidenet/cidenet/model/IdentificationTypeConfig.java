package com.cidenet.cidenet.model;

import com.cidenet.cidenet.repository.IdentificationTypeRepository;
import com.cidenet.cidenet.repository.WorkFieldRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class IdentificationTypeConfig {
    @Bean
    CommandLineRunner commandLineRunner(IdentificationTypeRepository repository) {
        return args -> {
            IdentificationType citizen = new IdentificationType(
                    "CEDULA DE CIUDADANIA",
                    "ACTIVE");
            IdentificationType foreign = new IdentificationType(
                    "CEDULA DE EXTRANJERIA",
                    "ACTIVE");
            IdentificationType passport = new IdentificationType(
                    "PASAPORTE",
                    "ACTIVE");
            IdentificationType permit = new IdentificationType(
                    "PERMISO ESPECIAL",
                    "ACTIVE");

            repository.saveAll(
                    List.of(citizen, foreign, passport, permit)
            );
        };
    }
}
