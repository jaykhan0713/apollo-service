package com.jay.apollo.core.domain.dependency.shopping;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

public record Order(
        UUID id,
        UUID userId,
        int totalTokens,
        String status,
        OffsetDateTime createdAt,
        List<ProductOrder> products
) {
    public record ProductOrder(
            Product product,
            int quantity
    ) {}
}
