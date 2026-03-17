package com.jay.apollo.app.shopping.service;

import java.util.List;

import com.jay.apollo.api.v1.shopping.ProductDto;
import com.jay.apollo.core.domain.dependency.shopping.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ShoppingApiMapper {
    ProductDto toProductDto(Product product);
}
