package de.hsos.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

    private String city;
    private String street;
    private Integer postcode;
    public Address() {

    }

    public Address(String city, String street, Integer postcode) {
        this.city = city;
        this.street = street;
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getPostcode() {
        return postcode;
    }

    public void setPostcode(Integer postcode) {
        this.postcode = postcode;
    }
}

// create an sql insert statement
// insert into Address (city, street, postcode) values ('Obunga', 'Ohyee Street 1', 12345);
// insert into Address (city, street, postcode) values ('Smogmog', 'Smogstrasse 7', 56789);
// insert into Address (city, street, postcode) values ('Aylmao', 'Hauptstraße', 12095);

