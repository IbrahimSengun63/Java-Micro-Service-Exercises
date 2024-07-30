package com.ibrahim.orderservice.webApi.controllers;

import com.ibrahim.orderservice.dtos.responses.ResponseGetProduct;
import com.ibrahim.orderservice.entities.Product;
import com.ibrahim.orderservice.webApi.clients.ProductServiceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/order-service")
@RequiredArgsConstructor
public class OrderController {
    private final ProductServiceClient productServiceClient;

    @PostMapping("/add")
    public void testFeign(@RequestParam int productId) {

        Product response = this.productServiceClient.getStockByProductId(productId);
        System.out.println(response.getId());
        System.out.println(response.getName());
        System.out.println(response.getStock());
    }
}
