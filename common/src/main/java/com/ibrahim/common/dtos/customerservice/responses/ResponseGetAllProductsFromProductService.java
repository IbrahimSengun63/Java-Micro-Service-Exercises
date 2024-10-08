package com.ibrahim.common.dtos.customerservice.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseGetAllProductsFromProductService {
    private int id;
    private String name;
    private int stock;
}
