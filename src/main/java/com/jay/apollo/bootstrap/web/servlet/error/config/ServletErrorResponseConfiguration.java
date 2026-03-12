package com.jay.apollo.bootstrap.web.servlet.error.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tools.jackson.databind.ObjectMapper;

import com.jay.apollo.web.error.ErrorResponseSpecFactory;
import com.jay.apollo.web.servlet.error.ErrorResponseWriter;

@Configuration
public class ServletErrorResponseConfiguration {

    @Bean
    public ErrorResponseWriter errorResponseWriter(
            ErrorResponseSpecFactory factory,
            ObjectMapper objectMapper
    ) {
        return new ErrorResponseWriter(factory, objectMapper);
    }
}
