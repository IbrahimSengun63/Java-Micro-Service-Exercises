package com.ibrahim.productservice.business.abstracts;

import com.ibrahim.common.dtos.productservice.requests.*;
import com.ibrahim.common.dtos.productservice.responses.*;

import java.util.List;

public interface ProductService {
    ResponseAddProduct addProduct(RequestAddProduct requestAddProduct);
    ResponseUpdateProduct updateProduct(RequestUpdateProduct requestUpdateProduct);
    ResponseGetProductById getProductById(RequestGetProductById requestGetProductById);
    ResponseGetProductByName getProductByName(RequestGetProductByName requestGetProductByName);
    List<ResponseGetAllProduct> getAllProduct();
}
