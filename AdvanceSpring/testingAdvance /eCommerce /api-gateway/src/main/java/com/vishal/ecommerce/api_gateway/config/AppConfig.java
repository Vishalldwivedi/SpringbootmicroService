package com.vishal.ecommerce.api_gateway.config;

import feign.Capability;
import feign.micrometer.MicrometerCapability;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.security.DrbgParameters;

@Configuration
public class AppConfig {

    @Bean
    public DrbgParameters.Capability capability(final MeterRegistry registry) {
        return new MicrometerCapability(registry);
    }
}