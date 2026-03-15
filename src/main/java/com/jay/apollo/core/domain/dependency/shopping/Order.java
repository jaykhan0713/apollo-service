package com.jay.apollo.core.domain.dependency.shopping;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

public record Order(
        UUID id,
        UUID userId,
        UUID idempotencyKey,
        int totalTokens,
        String status,
        OffsetDateTime createdAt,
        List<OrderItem> orderItems
) {

}
