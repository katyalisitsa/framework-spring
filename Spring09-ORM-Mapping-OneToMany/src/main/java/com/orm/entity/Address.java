package com.orm.entity;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
@NoArgsConstructor
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String zipCode;

    @ManyToOne // looks bi-directional but actually create 2 uni directional, not a good design
    //cannot use mappedBy here
    private Person person; //many address can be assigned to one person


    public Address(String street, String zipCode) {
        this.street = street;
        this.zipCode = zipCode;
    }
}