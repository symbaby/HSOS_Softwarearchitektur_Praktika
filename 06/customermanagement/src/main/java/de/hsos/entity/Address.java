package de.hsos.entity;

import javax.enterprise.context.Dependent;

@Dependent
public class Address {
    private String postcode;
    private String location;
    private String street;
    private String number;

    public Address() {

    }

    public Address(String postcode, String location, String street, String number) {
        this.postcode = postcode;
        this.location = location;
        this.street = street;
        this.number = number;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getLocation() {
        return location;
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }



}
