package com.thoughtworks.capability.gtb.restfulapidesign.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Student {

//    id 学号
//    name 姓名
//    gender 性别
//    note 备注信息
    private Integer id;
    private String name;
    private String gender;
    private String note;
}
