package com.consumingapi.controller;

import com.consumingapi.entity.Teacher;
import com.consumingapi.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiController {

    @Autowired
    TeacherRepository teacherRepository;

    @GetMapping("/teachers")
    public List<Teacher> readAllTeachers() {
        return teacherRepository.findAll();
    }

    @GetMapping("/students")

}
