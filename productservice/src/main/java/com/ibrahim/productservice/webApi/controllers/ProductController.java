package com.ibrahim.productservice.webApi.controllers;

import com.ibrahim.productservice.business.abstracts.ProductService;
import com.ibrahim.productservice.dtos.requests.RequestAddProduct;
import com.ibrahim.productservice.dtos.requests.RequestGetProductById;
import com.ibrahim.productservice.dtos.requests.RequestGetProductByName;
import com.ibrahim.productservice.dtos.requests.RequestUpdateProduct;
import com.ibrahim.productservice.dtos.responses.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product-service")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<ResponseAddProduct> addProduct(@RequestBody RequestAddProduct requestAddProduct) {
        ResponseAddProduct responseAddBook = this.productService.addProduct(requestAddProduct);
        return ResponseEntity.ok().body(responseAddBook);
    }

    @PostMapping("/update")
    public ResponseEntity<ResponseUpdateProduct> updateProduct(@RequestBody RequestUpdateProduct requestUpdateProduct) {
        ResponseUpdateProduct responseUpdateProduct = this.productService.updateProduct(requestUpdateProduct);
        return ResponseEntity.ok().body(responseUpdateProduct);
    }

    @GetMapping("/GetProductByName")
    public ResponseEntity<ResponseGetProductByName> getProductByName(@RequestParam String name) {
        RequestGetProductByName requestGetProductByName = new RequestGetProductByName();
        requestGetProductByName.setName(name);
        ResponseGetProductByName responseGetProductByName = this.productService.getProductByName(requestGetProductByName);
        return ResponseEntity.ok().body(responseGetProductByName);
    }

    @GetMapping("/GetProductById/{id}")
    public ResponseEntity<ResponseGetProductById> getProductById(@PathVariable int id) {
        RequestGetProductById requestGetProductById = new RequestGetProductById();
        requestGetProductById.setId(id);
        ResponseGetProductById responseGetProductById = this.productService.getProductById(requestGetProductById);
        return ResponseEntity.ok().body(responseGetProductById);
    }

    @GetMapping("/GetAll")

    public ResponseEntity<List<ResponseGetAllProduct>> getAllProducts() {
        List<ResponseGetAllProduct> responseGetAllProducts = this.productService.getAllProduct();
        return ResponseEntity.ok().body(responseGetAllProducts);
    }


}
