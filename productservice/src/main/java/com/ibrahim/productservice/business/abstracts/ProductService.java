package com.ibrahim.productservice.business.abstracts;

import com.ibrahim.productservice.dtos.requests.RequestAddProduct;
import com.ibrahim.productservice.dtos.requests.RequestGetProductById;
import com.ibrahim.productservice.dtos.requests.RequestGetProductByName;
import com.ibrahim.productservice.dtos.requests.RequestUpdateProduct;
import com.ibrahim.productservice.dtos.responses.*;

import java.util.List;

public interface ProductService {
    ResponseAddProduct addProduct(RequestAddProduct requestAddProduct);
    ResponseUpdateProduct updateProduct(RequestUpdateProduct requestUpdateProduct);
    ResponseGetProductById getProductById(RequestGetProductById requestGetProductById);
    ResponseGetProductByName getProductByName(RequestGetProductByName requestGetProductByName);
    List<ResponseGetAllProduct> getAllProduct();
}
