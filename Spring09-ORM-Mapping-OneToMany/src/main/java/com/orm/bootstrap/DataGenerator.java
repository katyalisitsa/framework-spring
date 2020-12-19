package com.orm.bootstrap;

import com.orm.entity.Address;
import com.orm.entity.Person;
import com.orm.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {
    @Autowired
    PersonRepository personRepository;
    @Autowired
    AddressRepository addressRepository;

    @Override
    public void run(String... args) throws Exception {
        Person p1 = new Person("Mike", "Smith");
        Person p2 = new Person("Ozzy", "Kmith");
        Person p3 = new Person("Tedd", "Bbith");

        Address a1 = new Address("123 King St", "12345");
        Address a2 = new Address("234 Elm St", "52543");
        Address a3 = new Address("542 Java St", "22414");

//        p1.setAddresses(Arrays.asList(a1,a2));//case-1
//        personRepository.save(p1);//case-1

        personRepository.save(p1); //double saving

        a1.setPerson(p1);
        a2.setPerson(p1);
        a3.setPerson(p1);

        addressRepository.save(a1);
        addressRepository.save(a2);
        addressRepository.save(a3);


    }
}


