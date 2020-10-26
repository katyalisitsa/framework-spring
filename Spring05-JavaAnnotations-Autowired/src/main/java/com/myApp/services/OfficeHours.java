package com.myApp.services;

import com.myApp.interfaces.ExtraSessions;

public class OfficeHours implements ExtraSessions {
    @Override
    public int getHours() {
        return 4;
    }
}
