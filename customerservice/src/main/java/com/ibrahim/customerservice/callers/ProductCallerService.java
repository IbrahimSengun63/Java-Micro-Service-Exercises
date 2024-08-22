package com.ibrahim.customerservice.callers;

import com.ibrahim.common.dtos.customerservice.responses.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductCallerService {
    Flux<ResponseGetAllProductsFromProductService> getAllProducts();
    Mono<ResponseGetProductFromProductService> getProductById(int id);

}
