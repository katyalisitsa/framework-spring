package com.orm.repository;

import com.orm.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {

    @Query("Select d from Department d where d.division in ?1")
    List<Department> getDepartmentByDivisionIn(List<String> division);

    List<Department> retrieveDepartemtnByDivision(String division);

    @Query(nativeQuery = true)
    List<Department> retrieveDepartmentByDivisionContains(String pattern);
}
