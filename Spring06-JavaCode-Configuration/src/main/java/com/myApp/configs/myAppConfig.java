package com.myApp.configs;

import com.myApp.interfaces.ExtraSessions;
import com.myApp.services.Java;
import com.myApp.services.OfficeHours;
import com.myApp.services.Selenium;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.myApp")
@PropertySource("classpath:application.properties")
public class myAppConfig {

    //Method level bean creation
    //Bean is used when using third-party classes and can not manipulate class to add @Component annotation
    @Bean
    public Java java(){

        //Adding bean name as a parameter for dependency injection
        return new Java(officeHours());
    }

    @Bean
    public Selenium selenium(){

        return new Selenium();
    }

    @Bean
    public OfficeHours officeHours(){

        return new OfficeHours();
    }

    //Polymorphic way
    //@Bean
    /*
     public ExtraSessions extraSessions(){
        return new OfficeHours();
    }
    */



}
