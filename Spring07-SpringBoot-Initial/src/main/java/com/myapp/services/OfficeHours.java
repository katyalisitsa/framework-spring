package com.myapp.services;

import com.myapp.interfaces.ExtraSession;
import org.springframework.stereotype.Component;

@Component
public class OfficeHours implements ExtraSession {
    @Override
    public int getHours() {
        return 7;
    }
}
