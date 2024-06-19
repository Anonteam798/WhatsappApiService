package com.infinity.bytes.WhatsappApiService.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Clase encargada de hacer las conversiones de las clases entities a dto
 */
@Configuration
public class ClassMapper {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
