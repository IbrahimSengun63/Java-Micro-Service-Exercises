package com.ibrahim.customerservice.webApi.clients;

import com.ibrahim.common.dtos.productservice.responses.ResponseGetAllProduct;
import reactor.core.publisher.Flux;

public interface ProductClient {
    Flux<ResponseGetAllProduct> getAllProducts();
}
