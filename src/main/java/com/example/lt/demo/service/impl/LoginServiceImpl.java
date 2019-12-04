package com.example.lt.demo.service.impl;

import com.example.lt.demo.mapper.UserMapper;
import com.example.lt.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public boolean checkUser(String userId, String password) {
        String userPassword = userMapper.findPasswordByUserId(userId);
        return password.equals(userPassword);
    }
}
