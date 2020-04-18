package com.example.lt.demo.mapper;

import com.example.lt.demo.model.Timetable;
import java.util.List;

import com.example.lt.framework.general.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TimetableMapper extends BaseMapper<Timetable> {

    int deleteByPrimaryKey(@Param("courseId") String courseId, @Param("courseName") String courseName, @Param("className") String className, @Param("weekly") String weekly, @Param("section") String section, @Param("roomName") String roomName);

    int insert(Timetable record);

    Timetable selectByPrimaryKey(@Param("courseId") String courseId, @Param("courseName") String courseName, @Param("className") String className, @Param("weekly") String weekly, @Param("section") String section, @Param("roomName") String roomName);

    List<Timetable> selectAll();

    int updateByPrimaryKey(Timetable record);
}