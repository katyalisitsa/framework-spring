package com.myApp.services;

import com.myApp.interfaces.Course;
import com.myApp.interfaces.ExtraSessions;

public class Java implements Course {

    private ExtraSessions extraSessions;

    public Java(ExtraSessions extraSessions) {
        this.extraSessions = extraSessions;
    }

    public void getTeachingHours() {

        System.out.println("Weekly Teaching Hours : " + (30 + extraSessions.getHours()));
    }

}
