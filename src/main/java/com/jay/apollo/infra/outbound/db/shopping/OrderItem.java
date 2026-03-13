package com.jay.apollo.infra.outbound.db.shopping;

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
public class OrderItem {
    @EmbeddedId
    private OrderItemId id;

    private Integer quantity;

    private Integer tokenPriceAtTime;

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
    public static class OrderItemId implements Serializable {
        private UUID orderId;
        private UUID productId;
    }

}