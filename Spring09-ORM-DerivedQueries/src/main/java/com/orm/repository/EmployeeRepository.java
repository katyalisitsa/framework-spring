package com.orm.repository;

import com.orm.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
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

    //Display all employees with salary higer than ''
    List<Employee> findBySalaryGreaterThan(Integer salary);

    //Display all employees that has been hired between '' and ''
    List<Employee> findByHireDateBetween(LocalDate start, LocalDate end);

    //Display all employees with salary greater and equal to '' in order
    List<Employee> findBySalaryGreaterThanEqualOrderBy(Integer salary);

    //Display top 3 unique employees that is making less than ''
    List<Employee> findDistinctTop3BySalaryLessThan(Integer salary);

    //Display all employees that do not have email address
    List<Employee> findByEmailIsNull();
}