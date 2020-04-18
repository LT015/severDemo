package com.example.lt.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.lt.demo.mapper.UserMapper;
import com.example.lt.demo.model.User;
import com.example.lt.demo.model.dto.UserDto;
import com.example.lt.demo.service.UserService;
import com.example.lt.framework.general.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    //@Cacheable(value = "user", key = "'user:'+#userId", unless = "#result==null")
    public UserDto getUserInfo(String userId) {
//        ValueOperations valueOperations = redisTemplate.opsForValue();
//        UserDto userDto;
//        if(valueOperations.get("first"+userId)!= null){
//            String user = valueOperations.get("first"+userId).toString();
//            userDto = JSON.parseObject(user,UserDto.class);
//        }else{
//            User user = this.selectByPrimaryKey(userId);
//            valueOperations.set("first"+userId,JSONObject.toJSON(userDto));
//        }
        User user = this.selectByPrimaryKey(userId);
        return handleUser(user);

    }

    @Override
    public List<UserDto> getUserList() {
        List<User> userList = userMapper.selectAll();

        return userList.stream().map(this::handleUser).collect(Collectors.toList());
    }

    public UserDto handleUser(User user) {
        UserDto userDto = new UserDto();
        userDto.setUserId(user.getUserId());
        userDto.setUserName(user.getUserName());
        userDto.setIdNumber(user.getIdNumber());
        userDto.setSex(user.getSex());
        userDto.setDeptId(user.getDeptId());
        userDto.setUserTitle(user.getUserTitle());
        userDto.setPosition(user.getPosition());
        userDto.setPhone(user.getPhone());
        userDto.setEmail(user.getEmail());
        userDto.setWechat(user.getWechat());
        userDto.setStatus(user.getStatus());
        return userDto;
    }
}
