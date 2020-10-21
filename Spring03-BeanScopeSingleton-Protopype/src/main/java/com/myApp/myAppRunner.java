package com.myApp;

import com.myApp.interfaces.Course;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class myAppRunner {

    public static void main(String[] args) {


        //Container need reference to the beans - config xml file
        ApplicationContext container = new ClassPathXmlApplicationContext("config.xml");

        Course course1 = container.getBean("java",Course.class);

        course1.getTeachingHours();

        Course course2 = container.getBean("java",Course.class);

        System.out.println("Pointing to the same object: " + (course1 == course2));
        System.out.println("Memory location for course1: " + course1);
        System.out.println("Memory location for course2: " + course2);

    }
}

