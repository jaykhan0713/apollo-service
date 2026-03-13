package com.jay.apollo.infra.outbound.db.shopping;

import java.time.OffsetDateTime;
import java.util.UUID;

import jakarta.persistence.*;

import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor  // Hibernate requires a no-arg constructor
@AllArgsConstructor
@Builder
@Table(name = "orders")
public class OrderJpaEntity {
    @Id
    private UUID id;

    private UUID userId;

    private Integer totalTokens;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private OffsetDateTime createdAt;

    public enum OrderStatus {
        PENDING, COMPLETE, CANCELLED
    }
}
