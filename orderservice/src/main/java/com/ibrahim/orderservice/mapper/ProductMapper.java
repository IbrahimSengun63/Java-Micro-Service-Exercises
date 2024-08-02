package com.ibrahim.orderservice.mapper;


import com.ibrahim.common.dtos.orderservice.requests.*;
import com.ibrahim.common.dtos.orderservice.responses.*;
import com.ibrahim.common.dtos.productservice.requests.*;
import com.ibrahim.common.dtos.productservice.responses.*;
import com.ibrahim.orderservice.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    RequestGetProductById requestGetProductFromProductServiceByIdProductToRequestGetProductById(RequestGetProductFromProductServiceById requestGetProductFromProductServiceById);
    ResponseGetProductFromProductService responseGetProductByIdToResponseGetProductFromProductService(ResponseGetProductById responseGetProductById);

    Product responseGetProductFromProductServiceToProduct(ResponseGetProductFromProductService responseGetProductFromProductService);
    ResponseGetProductFromProductService productToResponseGetProductFromProductService(Product product);


    RequestAddProduct requestAddProductFromOrderServiceToRequestAddProduct(RequestAddProductFromOrderService requestAddProductFromOrderService);
    ResponseAddProductToProductService responseAddProductToresponseAddProductToProductService(ResponseAddProduct responseAddProduct);

    Product responseAddProductToProductServiceToProduct(ResponseAddProductToProductService responseAddProductToProductService);
    ResponseAddProductToProductService productToResponseAddProductToProductService(Product product);
}
