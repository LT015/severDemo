package com.example.lt.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.lt.demo.mapper.UserMapper;
import com.example.lt.demo.model.dto.UserDto;
import com.example.lt.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    //@Cacheable(value = "user", key = "'user:'+#userId", unless = "#result==null")
    public UserDto getUserInfo(int userId) {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        UserDto userDto;
        if(valueOperations.get("first"+userId)!= null){
            String user = valueOperations.get("first"+userId).toString();
            userDto = JSON.parseObject(user,UserDto.class);
        }else{
            userDto = userMapper.findUser(userId);
            valueOperations.set("first"+userId,JSONObject.toJSON(userDto));
        }
        return userDto;

    }

    @Override
    public List<UserDto> getUserList() {

        return userMapper.selectAll();
    }
}
