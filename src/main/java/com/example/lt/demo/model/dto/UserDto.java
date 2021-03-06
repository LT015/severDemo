package com.example.lt.demo.model.dto;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String userId;

    private String userName;

    private String idNumber;

    private String sex;

    private Integer deptId;

    private String userTitle;

    private String position;

    private String phone;

    private String email;

    private String wechat;

    private Integer status;

}
