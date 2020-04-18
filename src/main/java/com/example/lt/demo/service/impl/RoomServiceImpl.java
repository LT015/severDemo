package com.example.lt.demo.service.impl;

import com.example.lt.demo.mapper.BuildingMapper;
import com.example.lt.demo.mapper.DepartmentMapper;
import com.example.lt.demo.mapper.RoomMapper;
import com.example.lt.demo.mapper.TimetableMapper;
import com.example.lt.demo.model.Building;
import com.example.lt.demo.model.Department;
import com.example.lt.demo.model.Room;
import com.example.lt.demo.model.dto.RoomDto;
import com.example.lt.demo.service.BuildingService;
import com.example.lt.demo.service.DepartmentService;
import com.example.lt.demo.service.RoomService;
import com.example.lt.demo.service.TimeTableService;
import com.example.lt.framework.general.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoomServiceImpl  extends BaseServiceImpl<Room> implements RoomService {

    @Autowired
    RoomMapper roomMapper;

    @Autowired
    TimeTableService timeTableService;

    @Autowired
    DepartmentService departmentService;

    @Autowired
    BuildingService buildingService;

    public List<RoomDto> selectByBuildingIdAndFloor(String buildingId, int floor) {
        List<Room> list = new ArrayList<>();
        if(floor != 0){
            list.addAll(this.creatQuery()
                    .andEqualTo("building_id",buildingId)
                    .andEqualTo("floor",floor)
                    .list());
        }else{
            list.addAll(this.creatQuery()
                    .andEqualTo("building_id",buildingId)
                    .list());
        }
        return  list.stream().map(this::handleRoom).collect(Collectors.toList());
    }

    public RoomDto selectByIdRoomName(String roomName){
        Room room = this.selectByPrimaryKey(roomName);
        return handleRoom(room);
    }

    public void updateRoom(){

    }

    private RoomDto handleRoom(Room room) {
        RoomDto roomDto  = new RoomDto();
        roomDto.setRoomName(room.getRoomName());
        roomDto.setFloor(room.getFloor());
        roomDto.setDoorNum(room.getDoorNum());
        roomDto.setCapacity(room.getCapacity());
        roomDto.setStatus(room.getStatus());
        roomDto.setArea(room.getArea());
        roomDto.setDeptId(room.getDeptId());
        roomDto.setBuildingId(room.getBuildingId());
        roomDto.setRoomManager(room.getRoomManager());

        Department department = departmentService.selectByPrimaryKey(room.getDeptId());
        roomDto.setDeptName(department.getDeptName());
        Building building = buildingService.selectByPrimaryKey(room.getBuildingId());
        roomDto.setBuildingName(building.getBuildingName());
        return roomDto;
    }

    private int getWeekday(String str){
        if(str.equals("星期一")){
            return 1;
        }else if(str.equals("星期二")){
            return 2;
        }else if(str.equals("星期三")){
            return 3;
        }else if(str.equals("星期四")){
            return 4;
        }else if(str.equals("星期五")){
            return 5;
        }else if(str.equals("星期六")){
            return 6;
        }else{
            return 7;
        }
    }


}