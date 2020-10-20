package com.thoughtworks.capability.gtb.restfulapidesign.api;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@Validated
public class StudentController {
    @Autowired
    StudentService studentService;

//    @GetMapping("/login")
//    public User login(@RequestParam @Pattern(regexp = "^[0-9a-zA-Z_]{3,10}$") String username, @RequestParam @Size(max = 12,min = 5) String password){
//        return loginService.login(username,password);
//    }

    @GetMapping("/students")
    public List<Student> getAll(){
        return studentService.getAll();
    }
}
