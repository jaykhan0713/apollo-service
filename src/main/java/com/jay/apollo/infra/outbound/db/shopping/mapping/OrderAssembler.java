package com.jay.apollo.infra.outbound.db.shopping.mapping;

import com.jay.apollo.core.domain.dependency.shopping.Order;
import com.jay.apollo.infra.outbound.db.shopping.entity.OrderItemJpaEntity;
import com.jay.apollo.infra.outbound.db.shopping.entity.OrderJpaEntity;

public class OrderAssembler {
    private final ShoppingMapper shoppingMapper;

    public OrderAssembler(ShoppingMapper shoppingMapper) {
        this.shoppingMapper = shoppingMapper;
    }

    public Order toOrder(
            OrderJpaEntity orderEntity,
            OrderItemJpaEntity orderItemEntity
    ) {
        return null;
    }
}
