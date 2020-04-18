package com.example.lt.demo.service;

import com.example.lt.demo.model.Room;
import com.example.lt.demo.model.dto.RoomDto;
import com.example.lt.framework.general.service.BaseService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public interface RoomService extends BaseService<Room> {

    List<RoomDto> selectByBuildingIdAndFloor(String buildingId, int floor);

    RoomDto selectByIdRoomName(String roomName);

    void updateRoom();

}
