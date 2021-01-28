package com.consumingapi.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Class extends BaseEntity{

    private String name;
    private Integer year;
    private Long courseId;
    private Long teacherId;

}
