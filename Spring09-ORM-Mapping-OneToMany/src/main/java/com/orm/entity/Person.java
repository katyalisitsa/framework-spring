package com.orm.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "persons")
@NoArgsConstructor
@Getter
@Setter
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    //mappedBy drop the ownership, and do not create additional table
    //this is how to use OneToMany which do not create additional table, preferred way
    private List<Address> addresses; //one to many relations, one person may have multiple addresses

//    @OneToMany(casacade=CasacadeType.ALL)
//    @JoinColumn(name="personId") //not a good way
//    private List<Address> addresses;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
