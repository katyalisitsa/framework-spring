package com.myapp.entity;

import com.myapp.enums.Gender;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "studentFirstName")
    private String firstName;
    @Column(name = "studentLastName")
    private String lastName;
    @Column(name = "studentEmail")
    private String email;

    @Transient
    private String city;

    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Temporal(TemporalType.TIME)
    private Date birthTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDateTime;

//    @Temporal(TemporalType.DATE)
//    private LocalDate localDate;
//    @Temporal(TemporalType.TIME)
//    private LocalTime localTime;
//    @Temporal(TemporalType.TIMESTAMP)
//    private LocalDateTime localDateTime;

    @Enumerated(EnumType.STRING)
    private Gender gender;
}
