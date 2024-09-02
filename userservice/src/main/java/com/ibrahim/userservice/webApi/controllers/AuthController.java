package com.ibrahim.userservice.webApi.controllers;

import com.ibrahim.common.dtos.userservice.requests.RequestLoginUser;
import com.ibrahim.common.dtos.userservice.requests.RequestRegisterUser;
import com.ibrahim.common.dtos.userservice.responses.ResponseLoginUser;
import com.ibrahim.common.dtos.userservice.responses.ResponseRegisterUser;
import com.ibrahim.userservice.business.abstracts.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user-service/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<ResponseRegisterUser> addUser(@RequestBody RequestRegisterUser requestRegisterUser) {
        ResponseRegisterUser response = authService.registerUser(requestRegisterUser);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseLoginUser> addUser(@RequestBody RequestLoginUser requestLoginUser) {
        ResponseLoginUser response = authService.loginUser(requestLoginUser);
        return ResponseEntity.ok(response);
    }


}
