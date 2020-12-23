package com.orm.repository;

import com.orm.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,String> {

    //Display all departments in the Furniture Department
    List<Department> findByDepartment(String department);

    //Display all departments in the Health Division
    List<Department> findByDivision(String division);

    //Display all departments with division name ends with 'ics'
    List<Department> findByDivisionEndsWith(String pattern);

    //Display top 3 departments with division name includes 'Hea', without duplicates
    List<Department> findDistinctTop3ByDivisionContains(String pattern);




}
