package com.example.lt.demo.service;

import com.example.lt.demo.model.Building;
import com.example.lt.framework.general.service.BaseService;

import java.util.List;

public interface BuildingService extends BaseService<Building> {

    Building create(Building building);

    void delete(int buildingId);

    List<Building> list();

    Building queryById(int buildingId) ;

    String queryNameById(int buildingId) ;

    Building updateDescription(int buildingId, String description);

    List<Building> getBuildingByName(String name);

}
