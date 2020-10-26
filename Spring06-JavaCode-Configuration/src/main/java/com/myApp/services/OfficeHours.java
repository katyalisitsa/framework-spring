package com.myApp.services;

import com.myApp.interfaces.ExtraSessions;
import lombok.ToString;

@ToString
public class OfficeHours implements ExtraSessions {
    @Override
    public int getHours() {
        return 7;
    }
}
