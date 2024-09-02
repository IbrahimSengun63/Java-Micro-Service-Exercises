package com.ibrahim.userservice.mappers;

import com.ibrahim.common.dtos.userservice.requests.RequestAddUser;
import com.ibrahim.common.dtos.userservice.responses.ResponseAddUser;
import com.ibrahim.common.dtos.userservice.responses.ResponseGetUser;
import com.ibrahim.userservice.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User RequestAddUserToUser(RequestAddUser requestAddUser);
    ResponseAddUser userToResponseAddUser(User user);

    ResponseGetUser userToResponseGetUser(User user);
}
