package com.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("professor")
public class ProfessorControler {

    @GetMapping("/show")
    public String showForm() {
        return "home";
    }
}
