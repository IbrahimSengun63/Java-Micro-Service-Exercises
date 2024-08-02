package com.ibrahim.common.dtos.orderservice.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseGetProductFromProductService {
    private int id;
    private String name;
    private int stock;
}
