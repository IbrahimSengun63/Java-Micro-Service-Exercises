package com.ibrahim.userservice.mappers;

import com.ibrahim.common.dtos.userservice.requests.RequestRegisterUser;
import com.ibrahim.common.dtos.userservice.responses.ResponseLoginUser;
import com.ibrahim.common.dtos.userservice.responses.ResponseRegisterUser;
import com.ibrahim.userservice.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthMapper {

    User requestRegisterUserToUser(RequestRegisterUser requestRegisterUser);
    ResponseRegisterUser userToResponseRegisterUser(User user);

    ResponseLoginUser userToResponseLoginUser(User user);
}
