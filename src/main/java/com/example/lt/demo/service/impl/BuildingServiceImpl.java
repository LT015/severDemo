package com.example.lt.demo.service.impl;

import com.example.lt.demo.mapper.BuildingMapper;
import com.example.lt.demo.model.Building;
import com.example.lt.demo.model.User;
import com.example.lt.demo.service.BuildingService;
import com.example.lt.demo.service.UserService;
import com.example.lt.framework.general.service.BaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class BuildingServiceImpl  extends BaseServiceImpl<Building> implements BuildingService {

    @Autowired
    BuildingMapper buildingMapper;

    public Building create(Building building) {
        // todo: check validity

        return null;
    }


    public void delete(int buildingId) {
        this.deleteByPrimaryKey(Integer.valueOf(buildingId));
    }

    public List<Building> list() {
        return this.selectAll().list();
    }

    public Building queryById(int buildingId) {
        Building building= this.selectByPrimaryKey(Integer.valueOf(buildingId));
        return building;
    }

    public String queryNameById(int buildingId) {
        Building building= this.selectByPrimaryKey(Integer.valueOf(buildingId));
        return  building.getBuildingName();
    }

    public Building updateDescription(int buildingId, String description) {
        Building building= this.selectByPrimaryKey(Integer.valueOf(buildingId));
        building.setBuildingDescribe(description);
        this.updateByPrimaryKey(building);
        return building;
    }

    public List<Building> getBuildingByName(String name) {
        List<Building> list = this.creatQuery().andLike("building_name", name).list();
        return list;
    }

}
