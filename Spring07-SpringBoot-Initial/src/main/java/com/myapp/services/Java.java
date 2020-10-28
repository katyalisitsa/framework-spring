package com.myapp.services;

import com.myapp.interfaces.Course;
import com.myapp.interfaces.ExtraSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Java implements Course {

    private ExtraSession extraSession;

    @Autowired
    public Java(ExtraSession extraSession){
        this.extraSession = extraSession;
    }

    @Override
    public int getTeachingHours() {
        return 20;
    }
}
