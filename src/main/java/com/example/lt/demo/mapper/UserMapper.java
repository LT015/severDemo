package com.example.lt.demo.mapper;

import com.example.lt.demo.model.User;
import com.example.lt.demo.model.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    List<UserDto> selectAll();

    UserDto findUser(@Param("userId") Integer userId);

    void insert(User user);
}
