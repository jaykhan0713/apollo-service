package com.jay.apollo.core.domain.dependency.shopping;

import java.time.OffsetDateTime;
import java.util.UUID;

public record Product(
        UUID id,
        String name,
        String description,
        int token_price,
        OffsetDateTime createdAt
) {
}
