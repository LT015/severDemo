package com.example.lt.demo.mapper;

import com.example.lt.demo.model.AppFlow;
import com.example.lt.demo.model.Occupation;
import java.util.List;

import com.example.lt.framework.general.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OccupationMapper extends BaseMapper<Occupation> {
    int deleteByPrimaryKey(@Param("occupationId") Integer occupationId, @Param("worktimeId") Integer worktimeId);

    int insert(Occupation record);

    Occupation selectByPrimaryKey(@Param("occupationId") Integer occupationId, @Param("worktimeId") Integer worktimeId);

    List<Occupation> selectAll();

    int updateByPrimaryKey(Occupation record);
}