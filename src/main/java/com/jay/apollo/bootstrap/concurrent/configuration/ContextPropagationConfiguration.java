package com.jay.apollo.bootstrap.concurrent.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jay.apollo.infra.concurrent.propagation.ContextPropagator;
import com.jay.apollo.infra.concurrent.propagation.identity.IdentityContextPropagator;
import com.jay.apollo.infra.concurrent.propagation.mdc.MdcContextPropagator;

@Configuration
public class ContextPropagationConfiguration {

    @Bean
    public ContextPropagator identityContextPropagator() {
        return new IdentityContextPropagator();
    }

    @Bean
    public ContextPropagator mdcContextPropagator() {
        return new MdcContextPropagator();
    }
}
