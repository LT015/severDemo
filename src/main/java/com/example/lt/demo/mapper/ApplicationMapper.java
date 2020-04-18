package com.example.lt.demo.mapper;

import com.example.lt.demo.model.AppFlow;
import com.example.lt.demo.model.Application;
import com.example.lt.framework.general.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ApplicationMapper extends BaseMapper<Application> {
    int deleteByPrimaryKey(Integer application);

    int insert(Application record);

    Application selectByPrimaryKey(Integer application);

    List<Application> selectAll();

    int updateByPrimaryKey(Application record);
}