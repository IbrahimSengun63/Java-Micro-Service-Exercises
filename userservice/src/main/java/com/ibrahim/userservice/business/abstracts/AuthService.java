package com.ibrahim.userservice.business.abstracts;

import com.ibrahim.common.dtos.userservice.requests.RequestLoginUser;
import com.ibrahim.common.dtos.userservice.requests.RequestRegisterUser;
import com.ibrahim.common.dtos.userservice.responses.ResponseLoginUser;
import com.ibrahim.common.dtos.userservice.responses.ResponseRegisterUser;

public interface AuthService {
    ResponseRegisterUser registerUser(RequestRegisterUser requestRegisterUser);
    ResponseLoginUser loginUser(RequestLoginUser requestLoginUser);
}
