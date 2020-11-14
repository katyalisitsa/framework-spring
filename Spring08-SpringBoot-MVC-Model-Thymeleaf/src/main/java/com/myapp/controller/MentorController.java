package com.myapp.controller;

import com.myapp.enums.Gender;
import com.myapp.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/mentor")
public class MentorController {

    @GetMapping("/list")
    public String showTable(Model model){
        List<Mentor> mentorList = new ArrayList<>();
        mentorList.add(new Mentor("Kate","Lysy", 26, Gender.FEMALE));
        mentorList.add(new Mentor("Zeynep","Mur", 26, Gender.FEMALE));
        mentorList.add(new Mentor("Ozzy","Ozzy", 42, Gender.MALE));

        model.addAttribute("mentors",mentorList);

        return "mentor/mentor-list";
    }
}
