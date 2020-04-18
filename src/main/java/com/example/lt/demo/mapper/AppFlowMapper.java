package com.example.lt.demo.mapper;

import com.example.lt.demo.model.AppFlow;
import java.util.List;

import com.example.lt.demo.model.Timetable;
import com.example.lt.framework.general.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AppFlowMapper extends BaseMapper<AppFlow> {
    int deleteByPrimaryKey(@Param("applicationId") Integer applicationId, @Param("flowId") Integer flowId);

    int insert(AppFlow record);

    AppFlow selectByPrimaryKey(@Param("applicationId") Integer applicationId, @Param("flowId") Integer flowId);

    List<AppFlow> selectAll();

    int updateByPrimaryKey(AppFlow record);
}