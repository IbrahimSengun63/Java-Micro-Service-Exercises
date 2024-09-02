package com.ibrahim.userservice.webApi.controllers;

import com.ibrahim.common.dtos.userservice.requests.RequestAddUser;
import com.ibrahim.common.dtos.userservice.responses.ResponseAddUser;
import com.ibrahim.common.dtos.userservice.responses.ResponseGetUser;
import com.ibrahim.userservice.business.abstracts.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user-service")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/add")
    public ResponseEntity<ResponseAddUser> addUser(@RequestBody RequestAddUser requestAddUser) {
        ResponseAddUser response = userService.addUser(requestAddUser);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseGetUser> getUser(@PathVariable Long id) {
        ResponseGetUser response = userService.getUser(id);
        return ResponseEntity.ok(response);
    }
}
