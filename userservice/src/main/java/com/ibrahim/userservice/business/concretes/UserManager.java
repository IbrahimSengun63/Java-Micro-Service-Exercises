package com.ibrahim.userservice.business.concretes;

import com.ibrahim.common.dtos.userservice.requests.RequestAddUser;
import com.ibrahim.common.dtos.userservice.responses.ResponseAddUser;
import com.ibrahim.common.dtos.userservice.responses.ResponseGetUser;
import com.ibrahim.userservice.business.abstracts.UserService;
import com.ibrahim.userservice.dataAccess.UserRepository;
import com.ibrahim.userservice.entities.User;
import com.ibrahim.userservice.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserManager implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Override
    @CacheEvict(value = "users", allEntries=true)
    public ResponseAddUser addUser(RequestAddUser requestAddUser) {
        User user = userMapper.requestAddUserToUser(requestAddUser);
        User savedUser = userRepository.save(user);
        return userMapper.userToResponseAddUser(savedUser);
    }

    @Override
    @Cacheable(value = "users", key = "#id")
    public ResponseGetUser getUser(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        return userMapper.userToResponseGetUser(user);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }
}
