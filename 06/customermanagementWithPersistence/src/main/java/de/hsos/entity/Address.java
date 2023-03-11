package de.hsos.entity;


import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Vetoed;
import javax.persistence.Embeddable;

@Dependent
@Embeddable
@Vetoed
public class Address {
    private String postcode;
    private String location;
    private String street;
    private String number;

    public Address() {
        this.postcode = "";
        this.location = "";
        this.street = "";
        this.number = "";
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


    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
