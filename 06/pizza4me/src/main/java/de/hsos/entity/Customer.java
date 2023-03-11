package de.hsos.entity;


import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Customer extends PanacheEntityBase {

    @Id
    @SequenceGenerator(name = "customerNumber", sequenceName = "customerNumber_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customerNumber")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    /*
    @OneToMany(fetch = FetchType.EAGER)
    private List<Ordering> orderingList;
    */


    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    private Ordering currentOrder;

    @Version
    Long version = 0L;

    public Customer() {
    }

    public Customer(String name, Address address) {

        // TODO:: Mit Cascade arbeiten!!! sieht aus wie scheisse (Annotation finden)
        this.currentOrder = new Ordering();
        persist(currentOrder);

        this.name = name;
        this.address = address;
    }

    public static Customer findCustomer(Long id) {
        return findById(id);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public Ordering getCurrentOrder() {
        return currentOrder;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setCurrentOrder(Ordering currentOrder) {
        this.currentOrder = currentOrder;
    }
}


