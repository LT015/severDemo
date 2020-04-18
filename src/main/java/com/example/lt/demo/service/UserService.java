package com.example.lt.demo.service;

import com.example.lt.demo.model.User;
import com.example.lt.demo.model.dto.UserDto;
import com.example.lt.framework.general.service.BaseService;

import java.util.List;

public interface UserService extends BaseService<User> {

    /**
     * 获取用户信息
     *
     * @param userId 用户id
     * @return 用户信息
     */
    UserDto getUserInfo(String userId);

    List<UserDto> getUserList();

}
