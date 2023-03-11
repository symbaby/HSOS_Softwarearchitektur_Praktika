package de.hsos.entity;


import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Vetoed;
import javax.persistence.*;

@Dependent
@Entity
@Vetoed
@NamedQuery(name = "Customers.findAll", query = "SELECT c FROM Customer c ORDER BY c.id", hints = @QueryHint(name = "org.hibernate.cacheable", value = "true"))
public class Customer {

    @Id
    private Integer id;
    private String firstname;
    private String lastname;

    @Embedded
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

    public Customer(){

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

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
