package com.myapp;

import com.myapp.calculator.Calculator;
import com.myapp.enums.City;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MyappApplication {

    public static void main(String[] args) throws Exception {

        ApplicationContext container = SpringApplication.run(MyappApplication.class, args);

        Calculator calculator = container.getBean("calculator", Calculator.class);

        System.out.println(calculator.getTotalCarpetCost(City.ARLINGTON));

    }


}
