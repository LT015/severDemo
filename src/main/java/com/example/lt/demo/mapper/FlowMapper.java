package com.example.lt.demo.mapper;

import com.example.lt.demo.model.AppFlow;
import com.example.lt.demo.model.Flow;
import java.util.List;

import com.example.lt.framework.general.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FlowMapper extends BaseMapper<Flow> {
    int deleteByPrimaryKey(@Param("flowId") Integer flowId, @Param("flowOrder") Integer flowOrder);

    int insert(Flow record);

    Flow selectByPrimaryKey(@Param("flowId") Integer flowId, @Param("flowOrder") Integer flowOrder);

    List<Flow> selectAll();

    int updateByPrimaryKey(Flow record);
}