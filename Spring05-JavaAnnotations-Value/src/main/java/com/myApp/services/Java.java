package com.myApp.services;

import com.myApp.interfaces.Course;
import com.myApp.interfaces.ExtraSessions;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@ToString
public class Java implements Course {

    @Value("CIS406 class - Java1")
    private String group;

    @Value("${instructor}")
    private String instructor;

    @Value("${days}")
    private String[] days;

    private ExtraSessions extraSessions;

    public Java(@Qualifier("officeHours") ExtraSessions extraSessions) {
        this.extraSessions = extraSessions;
    }

    public void getTeachingHours() {

        System.out.println("Weekly Teaching Hours : " + (20 + extraSessions.getHours()));
    }

}
