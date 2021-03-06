package com.mockmvc.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {

    private String firstName;
    private String lastName;
    private int age;

    public Student(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
}
