package com.myApp.services;

import com.myApp.interfaces.Course;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@ToString
public class Java implements Course {

    public void getTeachingHours() {

        System.out.println("Weekly Teaching Hours : " + (30));
    }

}
