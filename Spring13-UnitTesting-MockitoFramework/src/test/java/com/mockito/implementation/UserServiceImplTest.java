package com.mockito.implementation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    UserServiceImpl userService;

    @Test
    void deleteByUserName() {
        userService.deleteByUserName("mike@gmail.com");

        //verification
    }
}