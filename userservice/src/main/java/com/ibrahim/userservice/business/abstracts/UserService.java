package com.ibrahim.userservice.business.abstracts;

import com.ibrahim.common.dtos.userservice.requests.RequestAddUser;
import com.ibrahim.common.dtos.userservice.responses.ResponseAddUser;
import com.ibrahim.common.dtos.userservice.responses.ResponseGetUser;
import com.ibrahim.userservice.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    ResponseAddUser addUser(RequestAddUser requestAddUser);
    ResponseGetUser getUser(Long id);
    User saveUser(User user);
}
