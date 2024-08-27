package com.ibrahim.customerservice.webApi.clients;

import com.ibrahim.common.dtos.productservice.responses.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductClient {
    Flux<ResponseGetAllProduct> getAllProducts();
    Mono<ResponseGetProductById> getProductById(int id);
}
