package com.consumingapi.controller;

import com.consumingapi.entity.Address;
import com.consumingapi.entity.ResponseWrapper;
import com.consumingapi.entity.Teacher;
import com.consumingapi.repository.AddressRepository;
import com.consumingapi.repository.ParentRepository;
import com.consumingapi.repository.StudentRepository;
import com.consumingapi.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ApiController {

    private TeacherRepository teacherRepository;
    private StudentRepository studentRepository;
    private ParentRepository parentRepository;
    private AddressRepository addressRepository;

    public ApiController(TeacherRepository teacherRepository, StudentRepository studentRepository, ParentRepository parentRepository, AddressRepository addressRepository) {
        this.teacherRepository = teacherRepository;
        this.studentRepository = studentRepository;
        this.parentRepository = parentRepository;
        this.addressRepository = addressRepository;
    }

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

    @PutMapping("/address/{id}")
    public Address updateAddress(@PathVariable("id") long id, @RequestBody Address address) throws Exception {

        Optional<Address> foundAddress = addressRepository.findById(id);

        if (!foundAddress.isPresent()) {
            throw new Exception("Address was not found");
        }

        address.setCurrentTemperature(new Address().consumeTemp(address.getCity()));
        address.setId(foundAddress.get().getId());

        return addressRepository.save(address);
    }
}
