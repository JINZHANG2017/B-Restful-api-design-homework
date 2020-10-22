package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.dto.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class GroupService {
    private final StudentRepository studentRepository;

    private final static Integer GROUP_NUM=6;
    public GroupService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Group> getShuffledGroups() {
        List<Student> allStudents = studentRepository.getAllStudents();
        Collections.shuffle(allStudents);
        List<List<Student>> groupList=new ArrayList<>();
        for(int i=0;i<GROUP_NUM;i++){
            groupList.add(new ArrayList<>());
        }
        for(int i=0;i<allStudents.size();i++){
            int groupIndex=i%GROUP_NUM;
            groupList.get(groupIndex).add(allStudents.get(i));
        }
        List<Group> list=new ArrayList<>();
        for(int i=1;i<=GROUP_NUM;i++){
//            Team 1
            Group group=new Group(i,"Team "+i,"groupnote",groupList.get(i-1));
            list.add(group);
        }
        return list;
    }
}
