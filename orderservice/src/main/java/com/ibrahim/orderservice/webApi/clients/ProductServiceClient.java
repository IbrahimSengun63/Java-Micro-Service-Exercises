package com.ibrahim.orderservice.webApi.clients;

import com.ibrahim.orderservice.dtos.responses.ResponseGetProduct;
import com.ibrahim.orderservice.entities.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "productservice")
public interface ProductServiceClient {

    @GetMapping("/api/v1/product-service/GetProductById/{id}")
    Product getStockByProductId(@PathVariable("id") int productId);
}
