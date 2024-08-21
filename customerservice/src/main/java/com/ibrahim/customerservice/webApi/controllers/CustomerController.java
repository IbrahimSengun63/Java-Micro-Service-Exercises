package com.ibrahim.customerservice.webApi.controllers;

import com.ibrahim.common.dtos.customerservice.responses.ResponseGetAllProductsFromProductService;
import com.ibrahim.customerservice.callers.ProductCallerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/v1/customer-service")
@RequiredArgsConstructor
public class CustomerController {

    private final ProductCallerService productCallerService;

    @GetMapping("/getAllProducts")
    public ResponseEntity<Flux<ResponseGetAllProductsFromProductService>> getAllProducts() {
        Flux<ResponseGetAllProductsFromProductService> products = productCallerService.getAllProducts();
        return ResponseEntity.ok().body(products);
    }
}

