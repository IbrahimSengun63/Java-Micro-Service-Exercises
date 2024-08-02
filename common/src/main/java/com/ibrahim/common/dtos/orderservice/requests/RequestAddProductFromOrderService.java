package com.ibrahim.common.dtos.orderservice.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestAddProductFromOrderService {
    private String name;
    private int stock;
}
