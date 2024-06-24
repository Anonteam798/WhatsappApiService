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


    /**
     * Encargado de convertir una clase a otra siempre y cuando contenga
     * el mismo de nombre de atributos
     *
     * Utilizada para el cast entre DTO a ENTIDAD y viceversa
     * @param obj objeto a mapper
     * @param objClassToConvert clase de salida
     * @return Clase convertida
     * @param <T> Tipo de clase
     */
    public <T> T  mapClasses(Object obj, Class<T> objClassToConvert){
        return this.modelMapper().map(obj,objClassToConvert);
    }

}
