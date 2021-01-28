package com.consumingapi.entity;

import com.consumingapi.enums.EducationLevel;
import com.consumingapi.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@AllArgsConstructor
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"}, ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
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
