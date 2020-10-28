package com.myapp;

import com.myapp.interfaces.Course;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MyappApplication {

    public static void main(String[] args) {

        ApplicationContext container = SpringApplication.run(MyappApplication.class, args);

        Course course = container.getBean("java", Course.class);

        System.out.println(course.getTeachingHours());

        SpringApplication.run(MyappApplication.class, args);

    }

}
