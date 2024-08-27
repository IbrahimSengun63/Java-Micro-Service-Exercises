package com.ibrahim.customerservice.webApi.clients;

import com.ibrahim.common.dtos.productservice.responses.ResponseGetAllProduct;
import com.ibrahim.common.dtos.productservice.responses.ResponseGetProductById;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.time.Duration;
import java.util.List;

@Component
public class ProductWebClient implements ProductClient {

    private final WebClient client;

    public ProductWebClient(WebClient.Builder webClientBuilder) {
        this.client = webClientBuilder
                .baseUrl("http://localhost:8082/api/v1/product-service")
                .build();
    }

    @Override
    public Flux<ResponseGetAllProduct> getAllProducts() {
        return client.get()
                .uri("/GetAll")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<ResponseGetAllProduct>>() {
                })
                .flatMapMany(Flux::fromIterable); // Convert the List to Flux
    }

    @Override
    public Mono<ResponseGetProductById> getProductById(int id) {
        return Mono.delay(Duration.ofMillis(500))  // Delay of 500 milliseconds
                .then(client.get()
                        .uri("/GetProductById/{id}", id)
                        .retrieve()
                        .bodyToMono(ResponseGetProductById.class)
                        .retryWhen(Retry.backoff(3, Duration.ofSeconds(2)).jitter(0.75))
                );
    }
}

