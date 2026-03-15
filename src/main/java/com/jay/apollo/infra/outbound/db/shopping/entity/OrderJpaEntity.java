package com.jay.apollo.infra.outbound.db.shopping.entity;

import java.time.OffsetDateTime;
import java.util.List;
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

    private UUID idempotencyKey;

    private Integer totalTokens;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private OffsetDateTime createdAt;

    @OneToMany(mappedBy = "order")
    private List<OrderItemJpaEntity> orderItems;

    public enum OrderStatus {
        PENDING, COMPLETE, CANCELLED
    }
}
