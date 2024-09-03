package com.ibrahim.userservice.business.concretes;

import com.ibrahim.common.dtos.userservice.requests.RequestLoginUser;
import com.ibrahim.common.dtos.userservice.requests.RequestRegisterUser;
import com.ibrahim.common.dtos.userservice.responses.ResponseLoginUser;
import com.ibrahim.common.dtos.userservice.responses.ResponseRegisterUser;
import com.ibrahim.userservice.business.abstracts.AuthService;
import com.ibrahim.userservice.business.abstracts.UserService;
import com.ibrahim.userservice.config.JwtUtils;
import com.ibrahim.userservice.entities.User;
import com.ibrahim.userservice.mappers.AuthMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthManager implements AuthService {
    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;
    private final AuthMapper authMapper;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    @Override
    public ResponseRegisterUser registerUser(RequestRegisterUser requestRegisterUser) {
        User user = authMapper.requestRegisterUserToUser(requestRegisterUser);
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Encode password before saving
        User savedUser = userService.saveUser(user);
        return authMapper.userToResponseRegisterUser(savedUser);
    }


    @Override
    public ResponseLoginUser loginUser(RequestLoginUser requestLoginUser) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(requestLoginUser.getUsername(),requestLoginUser.getPassword()));
        UserDetails user = userService.loadUserByUsername(requestLoginUser.getUsername());
        String token = jwtUtils.generateToken(user.getUsername());
        ResponseLoginUser responseLoginUser = authMapper.userToResponseLoginUser((User) user);
        responseLoginUser.setToken(token);
        return  responseLoginUser;
    }
}
