package com.ibrahim.common.dtos.userservice.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseLoginUser {
    private Long id;
    private String username;
    private String password;
    private String token;
}
