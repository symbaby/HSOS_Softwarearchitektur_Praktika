package de.hsos.entity;

import javax.enterprise.context.Dependent;

@Dependent
public class Customer {

    private Integer id;
    private String firstname;
    private String lastname;
    private Address address;

    public Customer(Integer id, String firstname, String lastname, Address address){
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
    }

    public Customer(Integer id, String firstname, String lastname){
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = new Address();
    }


    public Integer getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Address getAddress() {
        return address;
    }


    public void setAddress(Address address) {
        this.address = address;
    }
}
