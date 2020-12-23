package com.orm;

import com.orm.repository.DepartmentRepository;
import com.orm.repository.EmployeeRepository;
import com.orm.repository.RegionRepositroty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class OrmApplication {

    @Autowired
    RegionRepositroty regionRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(OrmApplication.class, args);
    }

    @PostConstruct
    public void testRegions(){

        System.out.println("______________Regions start__________________");

        System.out.println("findByCountry: " + regionRepository.findAllByCountry("Canada"));

        System.out.println("findDistinctByCountry: " + regionRepository.findDistinctByCountry("Canada"));

        System.out.println("findByCountryContains" + regionRepository.findByCountryContains("United"));

        System.out.println("findByCountryContainingOrderByCountryDesc" + regionRepository.findByCountryContainingOrderByCountryDesc("United"));

        System.out.println("findTop2ByCountry" + regionRepository.findTopBy2ByCountry("Canada"));

        System.out.println("______________Regions end__________________");
    }

    @PostConstruct
    public void testDepartments(){

        System.out.println("______________Departments start__________________");
        System.out.println("______________Departments end__________________");
    }

    @PostConstruct
    public void testEmployees(){

        System.out.println("______________Employees start__________________");
        System.out.println("______________Employees end__________________");
    }
}
