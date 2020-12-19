package com.myApp;

import com.myApp.configs.myAppConfig;
import com.myApp.interfaces.Course;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class myAppRunner {
    public static void main(String[] args) {

        //can be more than one config file
        ApplicationContext container = new AnnotationConfigApplicationContext(myAppConfig.class);

        Course course = container.getBean("java", Course.class);

        System.out.println(course.toString());

        course.getTeachingHours();

    }
}
