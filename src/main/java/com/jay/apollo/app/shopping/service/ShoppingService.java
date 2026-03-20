package com.jay.apollo.app.shopping.service;

import java.util.List;

import com.jay.apollo.api.v1.shopping.ProductDto;
import com.jay.apollo.core.port.dependency.shopping.ShoppingDependency;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ShoppingService {

    private final ShoppingDependency shopping;
    private final ShoppingApiMapper mapper;

    public ShoppingService(
            ShoppingDependency shopping,
            ShoppingApiMapper mapper
    ) {
        this.shopping = shopping;
        this.mapper = mapper;
    }

    @Transactional(readOnly = true)
    public List<ProductDto> allProducts() {
        return this.shopping.products()
                .stream()
                .map(mapper::toProductDto)
                .toList();
    }
}
