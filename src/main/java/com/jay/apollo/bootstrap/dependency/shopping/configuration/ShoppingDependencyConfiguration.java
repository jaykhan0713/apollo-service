package com.jay.apollo.bootstrap.dependency.shopping.configuration;

import com.jay.apollo.core.port.dependency.shopping.ShoppingDependency;
import com.jay.apollo.infra.outbound.db.shopping.adapter.ShoppingAdapter;
import com.jay.apollo.infra.outbound.db.shopping.mapping.ShoppingMapper;
import com.jay.apollo.infra.outbound.db.shopping.repository.OrderItemJpaRepository;
import com.jay.apollo.infra.outbound.db.shopping.repository.OrderJpaRepository;
import com.jay.apollo.infra.outbound.db.shopping.repository.ProductJpaRepository;
import org.mapstruct.factory.Mappers;

public class ShoppingDependencyConfiguration {

    ShoppingDependency shoppingDependency(
            OrderJpaRepository orderRepo,
            OrderItemJpaRepository orderItemRepo,
            ProductJpaRepository productRepo
    ) {
        return new ShoppingAdapter(
                orderRepo,
                orderItemRepo,
                productRepo,
                Mappers.getMapper(ShoppingMapper.class)
        );
    }
}
