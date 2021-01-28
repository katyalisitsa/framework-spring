package com.consumingapi.entity;

import com.consumingapi.enums.AddressType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Address extends BaseEntity{

    private AddressType addressType;
    private String city;
    private String country;
    private Integer currentTemperature;
    private String postalCode;
    private String state;
    private String street;
}
