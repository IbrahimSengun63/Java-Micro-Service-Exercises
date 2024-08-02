package com.ibrahim.productservice.mappers;



import com.ibrahim.common.dtos.productservice.requests.*;
import com.ibrahim.common.dtos.productservice.responses.*;
import com.ibrahim.productservice.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product requestAddProductToProduct(RequestAddProduct requestAddProduct);
    ResponseAddProduct productToResponseAddProduct(Product product);

    Product requestUpdateProductToProduct(RequestUpdateProduct requestUpdateProduct);
    ResponseUpdateProduct productToResponseUpdateProduct(Product product);

    @Mapping(source = "id",target = "id")
    Product requestGetProductByIdToProduct(RequestGetProductById requestGetProductById);
    @Mapping(source = "id",target = "id")
    ResponseGetProductById productToResponseGetProductById(Product product);

    Product requestGetProductByNameToProduct(RequestGetProductByName requestGetProductByName);
    ResponseGetProductByName productToResponseGetProductByName(Product product);

    List<ResponseGetAllProduct> productsToResponseGetAllProduct(List<Product> products);

}
