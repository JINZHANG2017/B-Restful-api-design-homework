package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
    private List<Student> studentList=new ArrayList<>();

    public StudentRepository(){
        studentList.add(new Student(1,"张三","男","note"));
    }
    public List<Student> getAllStudents(){
        return studentList;
    }

    public Student getStudentById(Integer id){
        for(Student student:studentList){
            if(student.getId()==id){
                return student;
            }
        }
        return null;
    }

    public Student addStudent(Student student){
        student.setId(studentList.size()+1);
        studentList.add(student);
        return student;
    }

    public void alterStudent(Student student){
        for(Student stu:studentList){
            if(stu.getId()==student.getId()){
                stu.setGender(student.getGender());
                stu.setName(student.getName());
                stu.setNote(student.getNote());
            }
        }
    }

    public void deleteStudent(Integer id){
        studentList.remove(id-1);
        refreshId(id);
    }

    //删除user后更新之后的id
    private void refreshId(Integer id) {
        for(int i=id-1;i<studentList.size();i++){
            studentList.get(i).setId(studentList.get(i).getId()-1);
        }
    }
}
