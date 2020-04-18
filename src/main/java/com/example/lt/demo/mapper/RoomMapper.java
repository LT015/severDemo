package com.example.lt.demo.mapper;

import com.example.lt.demo.model.AppFlow;
import com.example.lt.demo.model.Room;
import com.example.lt.framework.general.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoomMapper extends BaseMapper<Room> {
    int deleteByPrimaryKey(String roomName);

    int insert(Room record);

    Room selectByPrimaryKey(String roomName);

    List<Room> selectAll();

    int updateByPrimaryKey(Room record);
}