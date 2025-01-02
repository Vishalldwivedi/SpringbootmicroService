package com.example.demo4.SecurityApp.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AppConfig {
//    Provides a ModelMapper bean used for object-to-object mapping.
//    Example: Mapping DTOs to Entities or vice versa
    @Bean
    ModelMapper getModelMapper() {
        ModelMapper mp =  new ModelMapper();
        return mp ;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
//    Secure, one-way hashing algorithm.
//    Provides a PasswordEncoder bean that uses BCrypt hashing for securely storing passwords.
}
