package com.mockmvc;

public class DataRepositoryImpl implements DataRepository {
    @Override
    public int[] findAll() {
        return new int[]{1, 2, 3};
    }
}
