package com.jay.apollo.api.v1.shopping;

import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "Product", description = "A purchasable product.")
public record ProductDto(
    @Schema(description = "Product ID", example = "...")
    UUID id,

    @Schema(description = "Product name", example = "Shadowblade")
    String name,

    @Schema(description = "Product description", example = "A blade forged in darkness")
    String description,

    @Schema(description = "Price in tokens", example = "100")
    int tokenPrice
) {}
