package com.jay.apollo.infra.outbound.db.shopping.entity;

import java.time.OffsetDateTime;
import java.util.UUID;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "products")
public class ProductJpaEntity {
    @Id
    private UUID id;

    private String name;

    private String description;

    private Integer tokenPrice;

    private OffsetDateTime createdAt;
}