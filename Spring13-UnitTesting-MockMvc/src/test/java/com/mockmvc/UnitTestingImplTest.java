package com.mockmvc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitTestingImplTest {


    @Test
    void calculateSum() {
        UnitTestingImpl unitTesting = new UnitTestingImpl();
        int actual = unitTesting.CalculateSum(new int[]{1, 2, 3});
        assertEquals(6, actual);
    }
}