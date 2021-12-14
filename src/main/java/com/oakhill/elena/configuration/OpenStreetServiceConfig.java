package com.oakhill.elena.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

// Access stored API key for OpenRouteService
@Configuration
@PropertySource("application.properties")
public class OpenStreetServiceConfig {
    @Value("${openstreetservice.api_key}")
    String api_key;

    public String getApi_key() {
        return this.api_key;
    }
    
}
