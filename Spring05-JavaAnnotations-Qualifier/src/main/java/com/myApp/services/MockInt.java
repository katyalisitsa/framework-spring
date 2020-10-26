package com.myApp.services;

import com.myApp.interfaces.ExtraSessions;
import org.springframework.stereotype.Component;

@Component
public class MockInt implements ExtraSessions {
    @Override
    public int getHours() {
        return 10;
    }
}
