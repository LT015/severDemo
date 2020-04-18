package com.example.lt.demo.mapper;

import com.example.lt.demo.model.AppFlow;
import com.example.lt.demo.model.WorkTime;
import com.example.lt.framework.general.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WorkTimeMapper extends BaseMapper<WorkTime> {
    int deleteByPrimaryKey(Integer worktimeId);

    int insert(WorkTime record);

    WorkTime selectByPrimaryKey(Integer worktimeId);

    List<WorkTime> selectAll();

    int updateByPrimaryKey(WorkTime record);
}