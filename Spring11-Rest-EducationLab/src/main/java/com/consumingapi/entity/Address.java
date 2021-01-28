package com.consumingapi.entity;

import com.consumingapi.enums.AddressType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@AllArgsConstructor
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "teacher"}, ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Address extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private AddressType addressType;
    private String city;
    private String country;

    @Column(name = "postal_code")
    private String postalCode;
    private String state;
    private String street;

    @OneToOne(mappedBy = "address")
    @JsonBackReference
    private Student student;

    @OneToOne(mappedBy = "address")
    @JsonIgnore
    private Parent parent;

    @OneToOne(mappedBy = "address")
    private Teacher teacher;

    private Integer currentTemperature;

    private Integer getCurrentTempreture() {
        return consumeTemp(this.city);
    }

    public Integer consumeTemp(String city) {
        return 5;
    }

}
