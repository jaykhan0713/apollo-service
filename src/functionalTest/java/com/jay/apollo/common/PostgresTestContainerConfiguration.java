package com.jay.apollo.common;

import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.postgresql.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

// pulls postgres from dockerhub and spins up single test container to connect to
public interface PostgresTestContainerConfiguration {

    @Container
    @ServiceConnection
    PostgreSQLContainer postgres = new PostgreSQLContainer(DockerImageName.parse("postgres:17"));
}