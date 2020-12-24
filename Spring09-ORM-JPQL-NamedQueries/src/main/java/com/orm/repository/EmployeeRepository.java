package com.orm.repository;

import com.orm.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

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
    Employee getEmployeeByEmailAndSalary(String email, Integer salary);

    //single named parameter
    @Query("Select e from Employee e weere e.salary = :salary")
    Employee getEmployeeBySalary(@Param("salary") Integer salary);

    ///multiple named parameters
    @Query("Select e from Employee e where e.firstName=:name or e.salary=:salary")
    List<Employee> getEmployeeByFirstNameOrSalary(@Param(firstName) String firstName, @Param(salary) Integer salary);

}
