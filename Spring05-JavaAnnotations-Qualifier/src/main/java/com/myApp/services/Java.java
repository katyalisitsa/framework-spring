package com.myApp.services;

import com.myApp.interfaces.Course;
import org.springframework.stereotype.Component;

@Component
public class Java implements Course {

    public void getTeachingHours() {

        System.out.println("Weekly Teaching Hours : " + (20));
    }

}
