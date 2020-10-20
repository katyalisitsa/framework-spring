package com.myApp.services;

import com.myApp.interfaces.Course;

public class Java implements Course {

    //One class has dependency on another class
    //Object from OfficeHours needs to be Injected to Java object -> Spring framework does it
    //Injection can be done through Constructor or Setters
    //Constructor injection - more popular - happens inside the Bean (Object into which another)
    //object needs to be injected

    OfficeHours officeHours;

    public Java(OfficeHours officeHours) {
        this.officeHours = officeHours;
    }

    public void getTeachingHours() {
        System.out.println("Weekly Teaching Hours : " + (20 + officeHours.getHours()));
    }
}
