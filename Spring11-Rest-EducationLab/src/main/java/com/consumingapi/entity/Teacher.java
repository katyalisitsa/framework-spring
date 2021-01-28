package com.consumingapi.entity;

import com.consumingapi.enums.EducationLevel;
import com.consumingapi.enums.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Teacher extends BaseEntity {
    private LocalDate birthday;
    private EducationLevel educationLevel;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String phoneNumber;
    private Status status;
    private String username;
    private Long addressId;

}
