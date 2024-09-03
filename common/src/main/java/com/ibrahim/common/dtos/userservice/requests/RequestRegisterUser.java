package com.ibrahim.common.dtos.userservice.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestRegisterUser {
    private String username;
    private String password;
    private BigDecimal balance;
}
