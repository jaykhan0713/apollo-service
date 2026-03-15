package com.jay.apollo.infra.outbound.db.shopping.mapping;

import com.jay.apollo.core.domain.dependency.shopping.Order;
import com.jay.apollo.core.domain.dependency.shopping.OrderItem;
import com.jay.apollo.infra.outbound.db.shopping.entity.OrderItemJpaEntity;
import com.jay.apollo.infra.outbound.db.shopping.entity.OrderJpaEntity;
import org.mapstruct.Mapper;

import com.jay.apollo.core.domain.dependency.shopping.Product;
import com.jay.apollo.infra.outbound.db.shopping.entity.ProductJpaEntity;

@Mapper
public interface ShoppingMapper {
    Order toOrder(OrderJpaEntity entity);

    OrderItem toOrderItem(OrderItemJpaEntity entity);

    Product toProduct(ProductJpaEntity entity);
}