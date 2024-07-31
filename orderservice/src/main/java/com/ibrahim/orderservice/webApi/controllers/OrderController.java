package com.ibrahim.orderservice.webApi.controllers;

import com.ibrahim.common.dtos.orderservice.requests.*;
import com.ibrahim.common.dtos.orderservice.responses.*;
import com.ibrahim.common.dtos.productservice.requests.*;
import com.ibrahim.common.dtos.productservice.responses.*;
import com.ibrahim.orderservice.callers.ProductCallerService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/order-service")
@RequiredArgsConstructor
public class OrderController {

    private final ProductCallerService productCallerService;

    @PostMapping("/add")
    public ResponseEntity<ResponseAddProductToProductService> testFeign(@RequestBody RequestAddProductFromOrderService requestAddProductFromOrderService) {
        ResponseAddProductToProductService responseAddProductToProductService = this.productCallerService.addProduct(requestAddProductFromOrderService);
        return ResponseEntity.ok().body(responseAddProductToProductService);
    }

    @GetMapping("Get")
    public ResponseEntity<ResponseGetProductFromProductService> testfeign2(@RequestParam int id) {
        RequestGetProductFromProductServiceById requestGetProductFromProductServiceById = new RequestGetProductFromProductServiceById();
        requestGetProductFromProductServiceById.setId(id);
        ResponseGetProductFromProductService responseGetProductFromProductService = this.productCallerService.getProduct(requestGetProductFromProductServiceById);
        return ResponseEntity.ok().body(responseGetProductFromProductService);
    }
}
