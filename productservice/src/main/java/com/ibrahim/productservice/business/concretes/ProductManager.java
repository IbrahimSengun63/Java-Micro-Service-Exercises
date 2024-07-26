package com.ibrahim.productservice.business.concretes;

import com.ibrahim.productservice.business.abstracts.ProductService;
import com.ibrahim.productservice.dataAccess.ProductRepository;
import com.ibrahim.productservice.dtos.requests.RequestAddProduct;
import com.ibrahim.productservice.dtos.requests.RequestGetProductById;
import com.ibrahim.productservice.dtos.requests.RequestGetProductByName;
import com.ibrahim.productservice.dtos.requests.RequestUpdateProduct;
import com.ibrahim.productservice.dtos.responses.*;
import com.ibrahim.productservice.entities.Product;
import com.ibrahim.productservice.mappers.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductManager implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ResponseAddProduct addProduct(RequestAddProduct requestAddProduct) {
        Product product = this.productMapper.requestAddProductToProduct(requestAddProduct);
        Product savedProduct = this.productRepository.save(product);
        return this.productMapper.productToResponseAddProduct(savedProduct);
    }

    @Override
    public ResponseUpdateProduct updateProduct(RequestUpdateProduct requestUpdateProduct) {
        Product product = this.productMapper.requestUpdateProductToProduct(requestUpdateProduct);
        Product updatedProduct = this.productRepository.save(product);
        return this.productMapper.productToResponseUpdateProduct(updatedProduct);
    }

    @Override
    public ResponseGetProductById getProductById(RequestGetProductById requestGetProductById) {
        Product product = this.productMapper.requestGetProductByIdToProduct(requestGetProductById);
        Product getProduct = this.productRepository.findById(product.getId()).orElseThrow();
        return this.productMapper.productToResponseGetProductById(getProduct);

    }

    @Override
    public ResponseGetProductByName getProductByName(RequestGetProductByName requestGetProductByName) {
        Product product = this.productMapper.requestGetProductByNameToProduct(requestGetProductByName);
        Product getProduct = this.productRepository.findByName(product.getName());
        return this.productMapper.productToResponseGetProductByName(getProduct);
    }

    @Override
    public List<ResponseGetAllProduct> getAllProduct() {
        List<Product> products = this.productRepository.findAll();
        return this.productMapper.productsToResponseGetAllProduct(products);
    }
}
