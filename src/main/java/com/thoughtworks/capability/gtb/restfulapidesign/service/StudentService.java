package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public List<Student> getAll(){
        return studentRepository.getAllStudents();
    }

    public Student getStudentById(Integer id){
        return studentRepository.getStudentById(id);
    }

    public Student addStudent(Student student){
        return studentRepository.addStudent(student);
    }

    public void deleteStudent(Integer id){
        studentRepository.deleteStudent(id);
    }

    public void alterStudent(Student student){
        studentRepository.alterStudent(student);
    }

    public List<Student> getAllWithGender(String gender) {
        List<Student> allStudents = studentRepository.getAllStudents();
        return allStudents.stream().filter(s -> s.getGender().equals(gender)).collect(Collectors.toList());
    }
}
