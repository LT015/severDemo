package com.example.lt.demo.service.impl;

import com.example.lt.demo.mapper.TimetableMapper;
import com.example.lt.demo.model.Timetable;
import com.example.lt.demo.model.dto.TimeTableDto;
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
public class TimeTableServiceImpl  extends BaseServiceImpl<Timetable> implements TimeTableService {

    @Autowired
    TimetableMapper timetableMapper;

    public List<TimeTableDto> list(String roomName,int year, int term) {
        List<Timetable> list = this.creatQuery().andEqualTo("roomName", roomName)
                .andEqualTo("year",2019)
                .andEqualTo("term",2)
                .setOrderByClause("section desc")
                .setDistinct(true)
                .list();
        return list.stream().map(this::handleTimeTable).collect(Collectors.toList());
    }

    public TimeTableDto handleTimeTable(Timetable timetable) {
        TimeTableDto timeTableDto = new TimeTableDto();
        timeTableDto.setCourseId(timetable.getCourseId());
        timeTableDto.setCourseName(timetable.getCourseName());
        timeTableDto.setClassName(timetable.getClassName());
        timeTableDto.setWeekly(timetable.getWeekly());
        timeTableDto.setSection(timetable.getSection());
        timeTableDto.setRoomName(timetable.getRoomName());
        timeTableDto.setUserName(timetable.getUserName());
        String section = timetable.getSection();
        section = section.replace(" ", "");
        int day = 0;
        if(section.charAt(0) == '一') {
            day = 1;
        }else if(section.charAt(0) == '二'){
            day = 2;
        }else if(section.charAt(0) == '三'){
            day = 3;
        }else if(section.charAt(0) == '四'){
            day = 4;
        }else if(section.charAt(0) == '五'){
            day = 5;
        }else if(section.charAt(0) == '六'){
            day = 6;
        }
        timeTableDto.setWeekday(day);
        int startNum = Integer.valueOf(section.charAt(2));
        int endNum = Integer.valueOf(section.charAt(4));
        timeTableDto.setStartNum(startNum);
        timeTableDto.setEndNum(endNum);
        return timeTableDto;
    }



}
