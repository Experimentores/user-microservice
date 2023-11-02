package com.edu.pe.usermicroservice.users.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("behaviourMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public UserMapper tripMapper() {
        return new UserMapper();
    }
}
