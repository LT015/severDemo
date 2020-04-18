package com.example.lt.demo.mapper;

import com.example.lt.demo.model.AppFlow;
import com.example.lt.demo.model.Department;
import com.example.lt.framework.general.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DepartmentMapper extends BaseMapper<Department> {
    int deleteByPrimaryKey(Integer deptId);

    int insert(Department record);

    Department selectByPrimaryKey(Integer deptId);

    List<Department> selectAll();

    int updateByPrimaryKey(Department record);
}