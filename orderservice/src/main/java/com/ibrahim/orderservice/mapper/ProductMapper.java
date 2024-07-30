package com.ibrahim.orderservice.mapper;

import com.ibrahim.orderservice.dtos.requests.RequestGetProductById;
import com.ibrahim.orderservice.dtos.responses.ResponseGetProduct;
import com.ibrahim.orderservice.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product requestGetProductByIdToProduct(RequestGetProductById requestGetProductById);
    ResponseGetProduct productToResponseGetProduct(Product product);
}
