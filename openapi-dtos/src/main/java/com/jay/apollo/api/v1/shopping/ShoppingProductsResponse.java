package com.jay.apollo.api.v1.shopping;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "ShoppingProductsResponse", description = "Shopping Products Response")
public record ShoppingProductsResponse (List<ProductDto> productDtos) {}
