package com.orm.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="departments")
@Getter
@Setter
@NoArgsConstructor
@ToString
@NamedQuery(name="Department.findDepartment",query="Select d from Department d where d.division=?1")
public class Department{

    @Id
    private String department;
    private String division;

    public Department(String department, String division) {
        this.department = department;
        this.division = division;
    }
}
