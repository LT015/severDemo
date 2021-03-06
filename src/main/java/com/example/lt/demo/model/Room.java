package com.example.lt.demo.model;

import lombok.Data;

@Data
public class Room {
    private String roomName;

    private Integer floor;

    private String doorNum;

    private Integer capacity;

    private String status;

    private Integer area;

    private Integer deptId;

    private Integer buildingId;

    private String roomManager;

}