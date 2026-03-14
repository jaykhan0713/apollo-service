package com.jay.apollo.infra.outbound.db.shopping.mapping;

import org.mapstruct.Mapper;

import com.jay.apollo.core.domain.dependency.shopping.Product;
import com.jay.apollo.infra.outbound.db.shopping.entity.ProductJpaEntity;

@Mapper
public interface ProductMapper {
    Product toProduct(ProductJpaEntity entity);
}