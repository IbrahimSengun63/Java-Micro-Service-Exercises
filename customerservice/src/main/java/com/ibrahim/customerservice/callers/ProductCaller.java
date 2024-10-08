package com.ibrahim.customerservice.callers;

import com.ibrahim.common.dtos.customerservice.responses.ResponseGetAllProductsFromProductService;
import com.ibrahim.common.dtos.customerservice.responses.ResponseGetProductFromProductService;
import com.ibrahim.customerservice.mappers.ProductMapper;
import com.ibrahim.customerservice.webApi.clients.ProductClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Component
@RequiredArgsConstructor
public class ProductCaller implements ProductCallerService{
    private final ProductClient productClient;
    private final ProductMapper productMapper;


    @Override
    public Flux<ResponseGetAllProductsFromProductService> getAllProducts() {
        return productClient.getAllProducts()
                .map(productMapper::responseToResponseGetAllProductsFromProductService);
    }

    @Override
    public Mono<ResponseGetProductFromProductService> getProductById(int id) {
        return Mono.defer(() -> productClient.getProductById(id)
                        .map(productMapper::responseToResponseGetProductFromProductService))
                .delaySubscription(Duration.ofMillis(500));  // Add a 500 ms delay before processing
    }


}

