package com.ppinto.springsandbox.configuration;

import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.context.annotation.Bean;

import java.util.TimeZone;

@JsonComponent
public class JacksonConfiguration {

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer objectMapperCustomizer() {
        return builder -> builder
                .modules(new JavaTimeModule(), new Jdk8Module())
                .timeZone(TimeZone.getTimeZone("UTC"));
    }
}
