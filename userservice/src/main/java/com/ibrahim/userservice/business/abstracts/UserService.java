package com.ibrahim.userservice.business.abstracts;

import com.ibrahim.common.dtos.userservice.requests.RequestAddUser;
import com.ibrahim.common.dtos.userservice.responses.ResponseAddUser;
import com.ibrahim.common.dtos.userservice.responses.ResponseGetUser;

public interface UserService {
    ResponseAddUser addUser(RequestAddUser requestAddUser);
    ResponseGetUser getUser(Long id);
}
