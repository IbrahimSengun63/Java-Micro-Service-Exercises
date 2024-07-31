package com.ibrahim.orderservice.webApi.clients;

import com.ibrahim.common.dtos.orderservice.requests.*;
import com.ibrahim.common.dtos.orderservice.responses.*;
import com.ibrahim.common.dtos.productservice.requests.*;
import com.ibrahim.common.dtos.productservice.responses.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "productservice")
public interface ProductServiceClient {

    @GetMapping("/api/v1/product-service/GetProductById/{id}")
    ResponseEntity<ResponseGetProductById> getStockByProductId(@PathVariable("id") int productId);

    @PostMapping("/api/v1/product-service/add")
    ResponseEntity<ResponseAddProduct> addProduct(@RequestBody RequestAddProduct requestAddProduct);
}
