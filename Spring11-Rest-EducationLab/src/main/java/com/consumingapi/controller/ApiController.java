package com.consumingapi.controller;

import com.consumingapi.entity.ResponseWrapper;
import com.consumingapi.entity.Teacher;
import com.consumingapi.repository.ParentRepository;
import com.consumingapi.repository.StudentRepository;
import com.consumingapi.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiController {

    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ParentRepository parentRepository;

    @GetMapping("/teachers")
    public List<Teacher> readAllTeachers() {
        return teacherRepository.findAll();
    }

    @GetMapping("/students")
    public ResponseEntity<ResponseWrapper> readAllStudents() {
        return ResponseEntity
                .ok(new ResponseWrapper("students are successfully retrieved", studentRepository.findAll()));
    }

    @GetMapping("/parents")
    public ResponseEntity<ResponseWrapper> readAllParents() {
        ResponseWrapper responseWrapper = new ResponseWrapper(true, "parents are successfully retrieved",
                HttpStatus.ACCEPTED.value(),
                parentRepository.findAll());

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(responseWrapper);
    }
}
