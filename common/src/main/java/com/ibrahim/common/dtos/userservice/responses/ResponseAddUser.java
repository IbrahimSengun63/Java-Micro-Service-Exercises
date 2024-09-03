package com.ibrahim.common.dtos.userservice.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseAddUser implements Serializable {
    private Long id;
    private String username;
    private String password;
    private BigDecimal balance;
}
