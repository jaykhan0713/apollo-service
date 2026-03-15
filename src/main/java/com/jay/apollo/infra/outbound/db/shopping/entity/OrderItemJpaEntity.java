package com.jay.apollo.infra.outbound.db.shopping.entity;

import java.io.Serializable;
import java.util.UUID;
import jakarta.persistence.*;

import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "order_items")
public class OrderItemJpaEntity {
    @EmbeddedId
    private OrderItemId id;

    private Integer quantity;

    private Integer tokenPriceAtTime;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    private OrderJpaEntity order;

    @ManyToOne
    @MapsId("productId")  // maps to the productId field in the composite key
    @JoinColumn(name = "product_id")
    private ProductJpaEntity product;

    /*
     * NOTE: Hibernate uses equals and hashCode to compare and cache entities by their ID,
     *  so without it you can get unexpected behavior.
     */
    @Embeddable
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    public static class OrderItemId implements Serializable { //Serializable is needed per JPA spec, cant infer on POJO
        private UUID orderId;
        private UUID productId;
    }

}