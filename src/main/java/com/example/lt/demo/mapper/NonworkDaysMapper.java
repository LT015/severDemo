package com.example.lt.demo.mapper;

import com.example.lt.demo.model.AppFlow;
import com.example.lt.demo.model.NonworkDays;
import com.example.lt.framework.general.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface NonworkDaysMapper extends BaseMapper<NonworkDays> {
    int deleteByPrimaryKey(Date offDay);

    int insert(NonworkDays record);

    List<NonworkDays> selectAll();
}