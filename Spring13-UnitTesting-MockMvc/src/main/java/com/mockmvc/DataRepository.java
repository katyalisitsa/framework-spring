package com.mockmvc;

public interface DataRepository {

    int[] findAll();

    int[] findById(int id);
}
