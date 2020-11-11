package com.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class HomeController {

    @RequestMapping
    public String getRequestMapping(){
        return "home";
    }


    //@GetMapping to replace
    @RequestMapping(method = RequestMethod.GET, value = "/myapp")
    public String getRequestMapping2(){
        return "home";
    }



    //@PostMapping to replace
    @RequestMapping(method = RequestMethod.POST, value = "/myapp")
    public String getRequestMapping3(){
        return "home";
    }



        @GetMapping("/home/{name}")
                public String pathVariableEx2(@PathVariable("name") String name){

            System.out.println("name is : " + name);
            return "home";
        }


    @GetMapping("/home/{name}/{email}")
    public String pathVariableEx(@PathVariable("name") String name, @PathVariable("email") String email){

        System.out.println("name is : " + name);
        System.out.println("email is : " + email);
        return "home";
    }

    @GetMapping("home/course")
    public String requestParamEx(@RequestParam("course") String course){
        System.out.println("name is : " + course);
        return "home";
    }

    @GetMapping(value="/course")
    public String requestParamEx3(@RequestParam(value = "name", required=false, defaultValue = "SpringBoot") String name){
        System.out.println("name is : " + name);
        return "home";
    }


}
