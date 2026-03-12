package com.jay.apollo.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(org.flywaydb.core.Flyway.class)
public class FlywayPresenceConfig {

    public FlywayPresenceConfig() {
        System.out.println("Flyway is on classpath");
    }

    @Bean
    CommandLineRunner flywayProbe(org.flywaydb.core.Flyway flyway) {
        return args -> {
            var info = flyway.info();

            System.out.println("---- Flyway probe ----");
            System.out.println("Current version: " + info.current());
            System.out.println("Pending count: " + info.pending().length);
            System.out.println("Applied count: " + info.applied().length);

            for (var migration : info.pending()) {
                System.out.println("Pending: " +
                        migration.getVersion() + " " +
                        migration.getDescription());
            }

            for (var migration : info.applied()) {
                System.out.println("Applied: " +
                        migration.getVersion() + " " +
                        migration.getDescription());
            }
        };
    }
}