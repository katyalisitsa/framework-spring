package com.mockmvc;

import java.util.Arrays;

public class UnitTestingImpl {

    public int CalculateSum(int[] data) {
        int sum = 0;
        return Arrays.stream(data).sum();
    }
}
