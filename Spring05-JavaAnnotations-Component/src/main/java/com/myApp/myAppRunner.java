package com.myApp;

import com.myApp.interfaces.Course;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class myAppRunner {
    public static void main(String[] args) {

        ApplicationContext container = new ClassPathXmlApplicationContext("config.xml");

        //Default Bean ID - lowercasing first letter of class name
        //Java class - Bean ID is 'java'
        Course course = container.getBean("java",Course.class);
        course.getTeachingHours();

        Course course2 = container.getBean("selenium", Course.class);
        course2.getTeachingHours();

        //If the class name is all capital letters - Bean ID is all capital as well
        Course course3 = container.getBean("API",Course.class);
        course3.getTeachingHours();


    }
}
