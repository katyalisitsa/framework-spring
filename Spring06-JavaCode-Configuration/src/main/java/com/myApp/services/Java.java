package com.myApp.services;

import com.myApp.interfaces.Course;
import com.myApp.interfaces.ExtraSessions;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;

@ToString
public class Java implements Course {

    private ExtraSessions extraSessions;

    public Java(ExtraSessions extraSessions) {
        this.extraSessions = extraSessions;
    }

    public void getTeachingHours() {

        System.out.println("Weekly Teaching Hours : " + (30 + extraSessions.getHours()));
    }

    @Value("CIS406 - Java1")
    private String group;

    @Value("${instructor}")
    private String instructor;

    @Value("${days}")
    private String[] days;

}
