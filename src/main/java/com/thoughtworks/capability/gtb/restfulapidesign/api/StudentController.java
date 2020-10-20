package com.thoughtworks.capability.gtb.restfulapidesign.api;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Validated
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentService studentService;

//    @GetMapping("/login")
//    public User login(@RequestParam @Pattern(regexp = "^[0-9a-zA-Z_]{3,10}$") String username, @RequestParam @Size(max = 12,min = 5) String password){
//        return loginService.login(username,password);
//    }

    @GetMapping
    public List<Student> getAll(){
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Integer id){
        return studentService.getStudentById(id);
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Integer id){
        studentService.deleteStudent(id);
    }

    @PutMapping("/{id}")
    public void alterStudent(@PathVariable Integer id,@RequestBody Student student){
        studentService.alterStudent(student);
    }
}
