package com.ibrahim.customerservice.webApi.controllers;

import com.ibrahim.common.dtos.customerservice.responses.*;

import com.ibrahim.customerservice.callers.ProductCallerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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

    @GetMapping("/getProductById/{id}")
    public ResponseEntity<Mono<ResponseGetProductFromProductService>> getProductById(@PathVariable int id) {
        Mono<ResponseGetProductFromProductService> product = productCallerService.getProductById(id);
        return ResponseEntity.ok().body(product);
    }
}

