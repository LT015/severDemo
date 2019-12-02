package com.example.lt.demo.service.impl;

import com.example.lt.demo.mapper.UserMapper;
import com.example.lt.demo.model.dto.UserDto;
import com.example.lt.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public UserDto getUserInfo(int userId) {
        UserDto userDto = userMapper.findUser(userId);
        return userDto;
    }

    @Override
    public List<UserDto> getUserList() {

        return userMapper.selectAll();
    }
}
