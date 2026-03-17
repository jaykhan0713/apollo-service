package com.jay.apollo.web.mvc.controller.v1.shopping;

import com.jay.apollo.api.v1.shopping.ShoppingProductsResponse;
import com.jay.apollo.app.shopping.service.ShoppingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShoppingController {

    private final ShoppingService shoppingService;

    public ShoppingController(ShoppingService shoppingService) {
        this.shoppingService = shoppingService;
    }

    @GetMapping("/api/v1/shopping/products")
    public ShoppingProductsResponse shoppingProductsResponse() {
        return new ShoppingProductsResponse(shoppingService.allProducts());
    }
}
