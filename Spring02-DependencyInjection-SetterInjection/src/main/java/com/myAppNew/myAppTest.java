package com.myAppNew;

import com.myAppNew.interfaces.Course;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class myAppTest {
    //Runner class on Top Level
    //Rest - layer down


    public static void main(String[] args) {


        //Container need reference to the beans - config xml file
        ApplicationContext container = new ClassPathXmlApplicationContext("config.xml");

        Course course = container.getBean("java", Course.class);

        course.getTeachingHours();

    }
}
