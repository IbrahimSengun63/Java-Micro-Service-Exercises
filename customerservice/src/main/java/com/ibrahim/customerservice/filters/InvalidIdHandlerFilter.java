package com.ibrahim.customerservice.filters;

import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.server.HandlerFilterFunction;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public class InvalidIdHandlerFilter implements HandlerFilterFunction<ServerResponse, ServerResponse> {

    @Override
    public Mono<ServerResponse> filter(ServerRequest request, HandlerFunction<ServerResponse> next) {
        String idParam = request.pathVariable("id");

        try {
            int id = Integer.parseInt(idParam);

            if (id < 1) {
                return ServerResponse.status(HttpStatus.FORBIDDEN).build();
            }
        } catch (NumberFormatException e) {
            return ServerResponse.status(HttpStatus.BAD_REQUEST).build();
        }

        // If the id is valid, continue with the next handler
        return next.handle(request);
    }
}
