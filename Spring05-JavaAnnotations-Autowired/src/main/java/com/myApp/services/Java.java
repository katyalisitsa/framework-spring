package com.myApp.services;

import com.myApp.interfaces.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Java implements Course {

    //Field injection
    /*@Autowired*/
    private OfficeHours officeHours;

    //Constructor injection using @Autowired annotation
    //Annotation is optional if only one constructor is creaed
    //Meaning lombok @AllArgsConst can be used instead
    @Autowired
    public Java(OfficeHours officeHours) {
        this.officeHours = officeHours;
    }


    public OfficeHours getOfficeHours() {
        return officeHours;
    }

    /*
   //Autowired annotation is mandatory for setter injection
    @Autowired
    public void setOfficeHours(OfficeHours officeHours) {
        this.officeHours = officeHours;
    }
    */


    @Override
    public void getTeachingHours() {
        System.out.println("Weekly teaching hours: " + (30 + officeHours.getHours()));
    }
}
