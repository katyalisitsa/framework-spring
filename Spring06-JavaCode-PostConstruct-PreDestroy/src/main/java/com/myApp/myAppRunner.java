package com.myApp;

import com.myApp.interfaces.Course;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class myAppRunner {
    public static void main(String[] args) {

        ApplicationContext container = new AnnotationConfigApplicationContext("MyAppConfig.class");

        Course course = container.getBean("java", Course.class);

        course.getTeachingHours();
        //System.out.println(course.toString());
        ((AnnotationConfigApplicationContext) container).close();

    }
}
