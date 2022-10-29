package com.hackDay.RetoHackDay.config;

import com.hackDay.RetoHackDay.usecase.KonectaUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public KonectaUseCase konectaUseCase(){
        return new KonectaUseCase();
    }
}
