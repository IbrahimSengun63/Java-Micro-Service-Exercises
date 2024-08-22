package com.ibrahim.customerservice.mappers;

import com.ibrahim.common.dtos.customerservice.responses.*;
import com.ibrahim.common.dtos.productservice.responses.*;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ResponseGetAllProductsFromProductService responseToResponseGetAllProductsFromProductService(ResponseGetAllProduct response);
    ResponseGetProductFromProductService responseToResponseGetProductFromProductService(ResponseGetProductById response);
}
