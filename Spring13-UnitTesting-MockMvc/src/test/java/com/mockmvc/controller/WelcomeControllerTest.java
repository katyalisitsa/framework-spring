package com.mockmvc.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(WelcomeController.class)
class WelcomeControllerTest {

    @Test
    void welcome() {
    }
}