package com.ibrahim.customerservice.callers;

import com.ibrahim.common.dtos.customerservice.responses.ResponseGetAllProductsFromProductService;
import reactor.core.publisher.Flux;

public interface ProductCallerService {
    Flux<ResponseGetAllProductsFromProductService> getAllProducts();
}
