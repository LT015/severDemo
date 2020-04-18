package com.example.lt.demo.mapper;

import com.example.lt.demo.model.AppFlow;
import com.example.lt.demo.model.Exam;
import java.util.Date;
import java.util.List;

import com.example.lt.framework.general.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ExamMapper extends BaseMapper<Exam> {
    int deleteByPrimaryKey(@Param("examId") String examId, @Param("startTime") Date startTime, @Param("endTime") Date endTime);

    int insert(Exam record);

    Exam selectByPrimaryKey(@Param("examId") String examId, @Param("startTime") Date startTime, @Param("endTime") Date endTime);

    List<Exam> selectAll();

    int updateByPrimaryKey(Exam record);
}