package de.hsos.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pizza extends PanacheEntityBase {

    @Id
    @SequenceGenerator(name = "pizzaNumber", sequenceName = "pizzaNumber_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pizzaNumber")
    private Long id;

    private String name;

    private double price;

    // private List<OrderPosition> orderPositionList = new ArrayList<>();

    @Version
    Long version = 0L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pizza() {
    }

    public Pizza(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}

// create an sql insert statement
// insert into pizza (name, price) values ('Margherita', 5.50);
// insert into pizza (name, price) values ('Salami', 6.50);
// insert into pizza (name, price) values ('Hawaii', 7.50);
// insert into pizza (name, price) values ('Vegetarian', 8.50);
