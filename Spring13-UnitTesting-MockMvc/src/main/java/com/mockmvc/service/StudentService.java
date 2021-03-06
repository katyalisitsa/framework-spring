package com.mockmvc.service;

import com.mockmvc.entity.Student;
import com.mockmvc.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudentData() {
        return studentRepository.findAll();
    }


}
