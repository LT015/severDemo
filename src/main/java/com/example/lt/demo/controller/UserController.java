package com.example.lt.demo.controller;


import com.example.lt.demo.model.dto.UserDto;
import com.example.lt.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/user")
@Api(value = "我的User层",description = "用户操作api")
public class UserController {

    @Autowired
    UserService userService;

    @ResponseBody
    @GetMapping("/get")
    @ApiOperation(value = "获取一个用户", notes = "根据用户id获取一个用户")
    @ApiResponses({
            @ApiResponse(code=100,message = "请求参数有错"),
            @ApiResponse(code=101,message = "未授权"),
            @ApiResponse(code=103,message = "禁止访问"),
            @ApiResponse(code=104,message = "请求路径不存在"),
            @ApiResponse(code=105,message = "服务器内部错误"),
    })
    public UserDto getUserById(HttpServletRequest request,
                               @RequestParam(value = "userId", required = false) int userId){
        UserDto userDto = userService.getUserInfo(userId);
        return userDto;
    }

    @ResponseBody
    @GetMapping("/getlist")
    @ApiOperation(value = "获取用户列表", notes = "获取所有的用户信息")
    public List<UserDto> getUserList(){
        return userService.getUserList();
    }


}
