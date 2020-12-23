package com.orm.repository;

import com.orm.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,String> {

    //Display all emplyees by email
    List<Employee> findByEmail(String email);

    //Display all employees with first name '' and last name '', also show all employees with email address ''
    List<Employee> findByFirstNameAndLastNameOrEmail(String firstName, String lastName, String email);

    //Display all employees that first name is not ''
    List<Employee> findByFirstNameNot(String firstName);

    //Display all meployees where last name starts with ''
    List<Employee> findByLastNameStartingWith(String pattern);
}
