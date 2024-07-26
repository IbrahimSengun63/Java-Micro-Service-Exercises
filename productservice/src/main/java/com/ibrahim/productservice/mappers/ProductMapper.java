package com.ibrahim.productservice.mappers;

import com.ibrahim.productservice.dtos.requests.RequestAddProduct;
import com.ibrahim.productservice.dtos.requests.RequestGetProductById;
import com.ibrahim.productservice.dtos.requests.RequestGetProductByName;
import com.ibrahim.productservice.dtos.requests.RequestUpdateProduct;
import com.ibrahim.productservice.dtos.responses.*;
import com.ibrahim.productservice.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product requestAddProductToProduct(RequestAddProduct requestAddProduct);
    ResponseAddProduct productToResponseAddProduct(Product product);

    Product requestUpdateProductToProduct(RequestUpdateProduct requestUpdateProduct);
    ResponseUpdateProduct productToResponseUpdateProduct(Product product);

    Product requestGetProductByIdToProduct(RequestGetProductById requestGetProductById);
    ResponseGetProductById productToResponseGetProductById(Product product);

    Product requestGetProductByNameToProduct(RequestGetProductByName requestGetProductByName);
    ResponseGetProductByName productToResponseGetProductByName(Product product);

    List<ResponseGetAllProduct> productsToResponseGetAllProduct(List<Product> products);

}
