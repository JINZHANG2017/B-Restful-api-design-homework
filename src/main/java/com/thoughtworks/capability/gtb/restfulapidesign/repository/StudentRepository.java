package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepository {
    private List<Student> studentList=new ArrayList<>();

    public StudentRepository(){
        studentList.add(new Student(1,"stu1","男","note"));
        studentList.add(new Student(2,"stu2","女","note"));
        studentList.add(new Student(3,"stu3","女","note"));
        studentList.add(new Student(4,"stu4","女","note"));
        studentList.add(new Student(5,"stu5","女","note"));
        studentList.add(new Student(6,"stu6","女","note"));
        studentList.add(new Student(7,"stu7","女","note"));
        studentList.add(new Student(8,"stu8","女","note"));
        studentList.add(new Student(9,"stu9","女","note"));
        studentList.add(new Student(10,"stu10","女","note"));
        studentList.add(new Student(11,"stu11","女","note"));
        studentList.add(new Student(12,"stu12","女","note"));
        studentList.add(new Student(13,"stu13","女","note"));
        studentList.add(new Student(14,"stu14","女","note"));
        studentList.add(new Student(15,"stu15","女","note"));
    }
    public List<Student> getAllStudents(){
        return studentList;
    }

    public Student getStudentById(Integer id){
        Optional<Student> studentFound = studentList.stream().filter(student -> student.getId() == id).findFirst();
        if(studentFound.isPresent()){
            return studentFound.get();
        }else{
            return null;
        }
    }

    public Student addStudent(Student student){
        student.setId(studentList.size()+1);
        studentList.add(student);
        return student;
    }

    public void alterStudent(Student student){
        Optional<Student> studentFound = studentList.stream().filter(s -> s.getId() == student.getId()).findFirst();
        if(studentFound.isPresent()){
            Student stu = studentFound.get();
            stu.setGender(student.getGender());
            stu.setName(student.getName());
            stu.setNote(student.getNote());
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
