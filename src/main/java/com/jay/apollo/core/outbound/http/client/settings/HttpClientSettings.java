package com.jay.apollo.core.outbound.http.client.settings;

import java.time.Duration;

import com.jay.apollo.core.outbound.resiliency.policy.ResiliencyPolicy;

public record HttpClientSettings(
        String clientName,
        String baseUrl,
        Duration connectTimeout,
        Duration readTimeout,
        ResiliencyPolicy resiliencyPolicy
) {}
