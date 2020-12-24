package com.orm.repository;

import com.orm.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("Select e from Employee e where e.email = 'dtrail8@tamu.edu'")
    Employee getEmployeeDetail();

    @Query("Select e.salary from Employee e where e.email = 'dtrail8@tamu.edu'")
    Integer getEmployeeSalary();

    //single bind parameter
    @Query("Select e from Employee e where e.email = ?1")
    Employee getEmployeeByEmail(String email);

    //multiple bind parameters
    @Query("Select e from Employee e where e.email = ?1 and e.salary = ?2")
    Employee getEmployeeByEmailAndSalary(String email, int salary);

    //single named parameter
    @Query("Select e from Employee e weere e.salary = :salary")
    Employee getEmployeeBySalary(@Param("salary") int salary);

    ///multiple named parameters
    @Query("Select e from Employee e where e.firstName=:name or e.salary=:salary")
    List<Employee> getEmployeeByFirstNameOrSalary(@Param(firstName) String firstName, @Param(salary) int salary);

    //not equal
    @Query("Select e from Employee e where e.salary <> ?1")
    List<Employee> getEmployeeBySalaryNotEqual(int salary);

    //Like/COntains/StartsWith/EndsWith
    @Query("Select e from Employee e where e.firstNamr LIKE ?1")
    List<Employee> getEmployeeByFirstNameLike(String pattern);

    @Query("Select e from Employee e where e.salary < ?1")
    List<Employee> getEmployeeBySalaryLessThan(int salary);

    @Query("Select e from Empoyee e where e.salary > ?1")
    List<Employee> getEmployeeBySalaryGreaterThan(int salary);

    @Query("Select e from Employee e where e.salary between ?1 and ?2")
    List<Employee> getEmployeeBySalaryBetween(int salary1, int salary2);

    @Query("Select e from Employee e where e.hireDate < ?1")
    List<Employee> getEmployeeByHireDateBefore(LocalDate date);

    @Query("Select e from Employee e where e.email is NULL")
    List<Employee> getEmployeeByEmailIsNull();

    @Query("Select e from Employee e where e.email is not NULL")
    List<Employee> getEmployeeByEmailIsNotNull();

}
