package com.ibrahim.userservice.business.concretes;

import com.ibrahim.common.dtos.userservice.requests.RequestAddUser;
import com.ibrahim.common.dtos.userservice.responses.ResponseAddUser;
import com.ibrahim.common.dtos.userservice.responses.ResponseGetUser;
import com.ibrahim.userservice.business.abstracts.UserService;
import com.ibrahim.userservice.dataAccess.UserRepository;
import com.ibrahim.userservice.entities.User;
import com.ibrahim.userservice.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserManager implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public ResponseAddUser addUser(RequestAddUser requestAddUser) {
        User user = userMapper.RequestAddUserToUser(requestAddUser);
        User savedUser = userRepository.save(user);
        return userMapper.userToResponseAddUser(user);
    }

    @Override
    public ResponseGetUser getUser(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        return userMapper.userToResponseGetUser(user);
    }
}
