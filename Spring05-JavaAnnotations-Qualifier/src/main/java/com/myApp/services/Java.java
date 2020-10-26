package com.myApp.services;

import com.myApp.interfaces.Course;
import com.myApp.interfaces.ExtraSessions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Java implements Course {

    @Autowired
    //ID of qualified bean
    @Qualifier("officeHours")
    private ExtraSessions extraSessions;

    /*@Autowired
    public Java(ExtraSessions extraSessions) {
        this.extraSessions = extraSessions;
    }*/

    public void getTeachingHours() {

        System.out.println("Weekly Teaching Hours : " + (20 + extraSessions.getHours()));
    }

}
