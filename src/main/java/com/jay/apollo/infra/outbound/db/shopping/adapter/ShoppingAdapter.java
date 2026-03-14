package com.jay.apollo.infra.outbound.db.shopping.adapter;

import java.util.List;

import com.jay.apollo.core.domain.dependency.shopping.Product;
import com.jay.apollo.core.port.dependency.shopping.ShoppingDependency;
import com.jay.apollo.infra.outbound.db.shopping.mapping.ProductMapper;
import com.jay.apollo.infra.outbound.db.shopping.repository.OrderItemJpaRepository;
import com.jay.apollo.infra.outbound.db.shopping.repository.OrderJpaRepository;
import com.jay.apollo.infra.outbound.db.shopping.repository.ProductJpaRepository;

public class ShoppingAdapter implements ShoppingDependency {
    private final OrderJpaRepository orderRepo;
    private final OrderItemJpaRepository orderItemRepo;
    private final ProductJpaRepository productRepo;
    private final ProductMapper productMapper;

    public ShoppingAdapter(
            OrderJpaRepository orderRepo,
            OrderItemJpaRepository orderItemRepo,
            ProductJpaRepository productRepo,
            ProductMapper productMapper
    ) {
        this.orderRepo = orderRepo;
        this.orderItemRepo = orderItemRepo;
        this.productRepo = productRepo;
        this.productMapper = productMapper;
    }

    public List<Product> products() {
        return productRepo.findAll()
                .stream()
                .map(productMapper::toProduct)
                .toList(); //unmodifiable list
    }
}
