package com.myApp.services;

import com.myApp.interfaces.Course;

public class Java implements Course {

    public void getTeachingHours() {

        System.out.println("Weekly Teaching Hours : " + (20));
    }

    public void myInitMethod() {
        System.out.println("Executing init method");
    }

    public void myDestroyMethod() {
        System.out.println("Executing destroy method");
    }

}
