package com.ibrahim.orderservice.callers;

import com.ibrahim.common.dtos.orderservice.requests.*;
import com.ibrahim.common.dtos.orderservice.responses.*;
import com.ibrahim.common.dtos.productservice.requests.*;
import com.ibrahim.common.dtos.productservice.responses.*;
import com.ibrahim.orderservice.mapper.ProductMapper;
import com.ibrahim.orderservice.webApi.clients.ProductServiceClient;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductCaller implements ProductCallerService {

    private final ProductServiceClient productServiceClient;
    private final ProductMapper productMapper;
    private static final Logger logger = LoggerFactory.getLogger(ProductCaller.class);


    @Override
    public ResponseGetProductFromProductService getProduct(RequestGetProductFromProductServiceById requestGetProductFromProductServiceById) {
        int id = requestGetProductFromProductServiceById.getId();
        ResponseGetProductById responseGetProductById = this.productServiceClient.getStockByProductId(id).getBody();
        logger.info("Get product log: {}", ProductCaller.class.getSimpleName());
        return this.productMapper.responseGetProductByIdToResponseGetProductFromProductService(responseGetProductById);
    }

    @Override
    public ResponseAddProductToProductService addProduct(RequestAddProductFromOrderService requestAddProductFromOrderService) {
        RequestAddProduct requestAddProduct = this.productMapper.requestAddProductFromOrderServiceToRequestAddProduct(requestAddProductFromOrderService);
        ResponseAddProduct responseAddProduct = this.productServiceClient.addProduct(requestAddProduct).getBody();
        return this.productMapper.responseAddProductToresponseAddProductToProductService(responseAddProduct);
    }
}
