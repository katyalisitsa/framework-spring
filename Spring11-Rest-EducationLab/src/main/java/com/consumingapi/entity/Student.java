package com.consumingapi.entity;

import com.consumingapi.enums.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Student extends BaseEntity{

    private String birthday;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String phoneNumber;
    private Status status;
    private String username;
    private Long addressId;
    private Long parentId;
}
