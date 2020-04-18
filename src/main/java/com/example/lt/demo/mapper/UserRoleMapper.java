package com.example.lt.demo.mapper;

import com.example.lt.demo.model.AppFlow;
import com.example.lt.demo.model.UserRole;
import java.util.List;

import com.example.lt.framework.general.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserRoleMapper extends BaseMapper<UserRole> {
    int deleteByPrimaryKey(@Param("userId") String userId, @Param("roleId") Integer roleId);

    int insert(UserRole record);

    List<UserRole> selectAll();
}