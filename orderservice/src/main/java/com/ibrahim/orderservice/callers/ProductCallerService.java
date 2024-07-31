package com.ibrahim.orderservice.callers;

import com.ibrahim.common.dtos.orderservice.requests.*;
import com.ibrahim.common.dtos.orderservice.responses.*;
import com.ibrahim.common.dtos.productservice.requests.*;
import com.ibrahim.common.dtos.productservice.responses.*;

public interface ProductCallerService {

    ResponseGetProductFromProductService getProduct(RequestGetProductFromProductServiceById requestGetProductFromProductServiceById);
    ResponseAddProductToProductService addProduct(RequestAddProductFromOrderService requestAddProductFromOrderService);
}
