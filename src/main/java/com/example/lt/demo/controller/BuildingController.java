package com.example.lt.demo.controller;

import com.example.lt.demo.model.Building;
import com.example.lt.demo.service.impl.BuildingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

@RestController
@RequestMapping("/LBS/building")
public class BuildingController {

    @Autowired
    BuildingServiceImpl buildingServiceImpl;

    @ResponseBody
    @PutMapping
    public Building create(@RequestBody Building building) {
        return buildingServiceImpl.create(building);
    }

    @DeleteMapping(value = "/{buildingId:.+}")
    public void delete(@PathVariable int buildingId) {
        buildingServiceImpl.delete(buildingId);
    }

    @GetMapping("/name/{name:.+}")
    public List<Building> getBuildingByType(@PathVariable String name) throws UnsupportedEncodingException {
        name = URLDecoder.decode(name, "utf-8");
        return buildingServiceImpl.getBuildingByName(name);
    }

    @ResponseBody
    @GetMapping("/list")
    public List<Building> list() {
        return buildingServiceImpl.list();
    }

    @ResponseBody
    @GetMapping("/{id:.+}")
    public Building getById(@PathVariable int id) {
        return buildingServiceImpl.queryById(id);
    }

    @ResponseBody
    @GetMapping("/getname/{id:.+}")
    public String getNameById(@PathVariable int id) {
        return buildingServiceImpl.queryNameById(id);
    }

    @ResponseBody
    @PostMapping("/update/description/{id:.+}/{description:.+}")
    public Building updateDescription(@PathVariable int id, @PathVariable String description) {
        return buildingServiceImpl.updateDescription(id, description);
    }

}
