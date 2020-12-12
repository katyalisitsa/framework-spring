package com.myapp;

import com.myapp.entity.Car;
import com.myapp.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class OrmconfigApplication {

    @Autowired
    CarRepository carRepository;

    public static void main(String[] args) {
        SpringApplication.run(OrmconfigApplication.class, args);
    }

    @PostConstruct
    public void dataInit() {
        Car c1 = new Car(1, "BMW", "X6");
        Car c2 = new Car(2, "BMW", "X3");
        Car c3 = new Car(3, "BMW", "X1");

        carRepository.save(c1);
        carRepository.save(c2);
        carRepository.save(c3);
    }
}

