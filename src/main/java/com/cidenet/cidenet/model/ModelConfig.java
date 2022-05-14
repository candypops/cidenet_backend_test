package com.cidenet.cidenet.model;

import com.cidenet.cidenet.repository.CountryRepository;
import com.cidenet.cidenet.repository.IdentificationTypeRepository;
import com.cidenet.cidenet.repository.WorkFieldRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ModelConfig {
    @Bean
    CommandLineRunner commandLineRunner(WorkFieldRepository repository,
                                        CountryRepository countryRepository,
                                        IdentificationTypeRepository identificationTypeRepository) {
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

            Country colombia = new Country(
                    "COLOMBIA",
                    "ACTIVE");
            Country usa = new Country(
                    "ESTADOS UNIDOS",
                    "ACTIVE");

            countryRepository.saveAll(
                    List.of(colombia, usa)
            );

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

            identificationTypeRepository.saveAll(
                    List.of(citizen, foreign, passport, permit)
            );
        };
    }

}
