package com.myAppNew.services;

import com.myAppNew.interfaces.Course;

import com.myAppNew.interfaces.ExtraSessions;
import lombok.Data;


@Data
public class Java implements Course {

    private ExtraSessions extraSessions;
/*
    public OfficeHours getOfficeHours() {
        return officeHours;
    }
    public void setOfficeHours(OfficeHours officeHours) {
        this.officeHours = officeHours;
    }
 */

    public void getTeachingHours() {
        System.out.println("Weekly Teaching Hours : " + (20 + extraSessions.getHours()));
    }
}