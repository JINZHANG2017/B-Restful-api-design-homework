package com.thoughtworks.capability.gtb.restfulapidesign.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Group {
//    id 组号
//    name 组名
//    note 备注
    private Integer id;
    private String groupName;
    private String note;
    private List<Student> studentList;
}
