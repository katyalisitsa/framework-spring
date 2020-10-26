package com.myApp.configs;

import com.myApp.services.Java;
import com.myApp.services.Selenium;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.myApp")
public class myAppConfig {

    //Method level bean creation
    @Bean
    public Java java(){
        return new Java();
    }

    @Bean
    public Selenium selenium(){
        return new Selenium();
    }




}
